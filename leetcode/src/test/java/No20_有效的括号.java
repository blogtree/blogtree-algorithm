import org.junit.Test;

import java.util.Stack;

/**
 * @see <a href="https://leetcode-cn.com/problems/valid-parentheses/"></a>
 */
public class No20_有效的括号 {

    @Test
    public void test1() {
        assert isValid("()");
        assert !isValid("(]");
        assert !isValid("([)]");
        assert isValid("{[]}");

    }

    @Test
    public void test2() {
        assert isValid("()[]{}");
        assert !isValid("((");
    }

    @Test
    public void test3() {
        assert !isValid("){");
    }

    /**
     * 1 字符串长度为奇数，返回false
     * 2 创建一个栈，存储左括号
     * 3-1 字符串转为字符数组，遍历数组
     * 3-2 如果为左括号，则存储到栈中；如果为右括号，则匹配栈中的左括号
     * 3-3 如果匹配成功，则出栈，继续循环；如果匹配失败，则返回false
     * 3-4 匹配失败：找不到左括号、找不到对应的左括号
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                Character first = stack.peek();
                if (first == null) {
                    return false;
                } else {
                    if ('(' == first && ')' == c
                            || '[' == first && ']' == c
                            || '{' == first && '}' == c) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.size() == 0;
    }
}

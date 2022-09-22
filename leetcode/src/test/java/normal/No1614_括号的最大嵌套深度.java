package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/"></a>
 */
@Slf4j
public class No1614_括号的最大嵌套深度 {

    @Test
    public void test1() {
        assert 3 == maxDepth("(1+(2*3)+((8)/4))+1");
        assert 3 == maxDepth("(1)+((2))+(((3)))");
        assert 1 == maxDepth("1+(2*3)/(2-1)");
        assert 0 == maxDepth("1");
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：遍历每个字符，如果是左括号，则+1；如果是右括号，则-1。存储左括号的最大值。
     */
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int maxDepth = 0;
        int tempDepth = 0;
        for (char c : chars) {
            if (c == '(') {
                tempDepth++;
                if (tempDepth > maxDepth) {
                    maxDepth = tempDepth;
                }
            } else if (c == ')') {
                tempDepth--;
            }
        }
        return maxDepth;
    }
}

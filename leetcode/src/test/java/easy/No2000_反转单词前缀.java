package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/reverse-prefix-of-word/"></a>
 */
@Slf4j
public class No2000_反转单词前缀 {

    @Test
    public void test1() {
        assert "dcbaefd".equals(reversePrefix("abcdefd", 'd'));
        assert "zxyxxe".equals(reversePrefix("xyxzxe", 'z'));
        assert "abcd".equals(reversePrefix("abcd", 'z'));
        assert "cbad".equals(reversePrefix("abcd", 'c'));
        assert "a".equals(reversePrefix("a", 'c'));
        assert "a".equals(reversePrefix("a", 'a'));
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(String.valueOf(ch));
        if (index == -1) {
            return word;
        }
        char[] chars = word.toCharArray();
        char temp;
        for (int i = 0; i < index / 2 + 1; i++) {
            temp = chars[i];
            chars[i] = chars[index - i];
            chars[index - i] = temp;
        }
        return String.valueOf(chars);
    }
}

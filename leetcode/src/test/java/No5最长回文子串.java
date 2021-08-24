import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/"></a>
 * <p>
 * 题目：给你一个字符串 s，找到 s 中最长的回文子串。
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 */
public class No5最长回文子串 {

    @Test
    public void test() {
        assert "aaaa".equals(longestPalindrome("aaaa"));
        assert "bab".equals(longestPalindrome("babad"));
        assert "bb".equals(longestPalindrome("cbbd"));
        assert "a".equals(longestPalindrome("ac"));
        assert "bb".equals(longestPalindrome("bb"));
        assert "aca".equals(longestPalindrome("aacabdkacaa"));
    }

    public String longestPalindrome(String s) {
        // 字符串长度为1
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        String longestStr = s.substring(0, 1);
        int longestLength = 1;
        int j;
        for (int i = 0; i < chars.length; i++) {
            // 向左右查找奇回文
            for (j = 1; i - j >= 0 && i + j < chars.length; j++) {
                if (chars[i - j] == chars[i + j]) {
                    if (j * 2 + 1 > longestLength) {
                        longestStr = s.substring(i - j, i + j + 1);
                        longestLength = longestStr.length();
                    }
                } else {
                    break;
                }
            }
            // 向右查找偶回文
            for (j = 1; i - j + 1 >= 0 && i + j < chars.length; j++) {
                if (chars[i - j + 1] == chars[i + j]) {
                    if (j * 2 > longestLength) {
                        longestStr = s.substring(i - j + 1, i + j + 1);
                        longestLength = longestStr.length();
                    }
                } else {
                    break;
                }
            }
        }
        return longestStr;
    }
}

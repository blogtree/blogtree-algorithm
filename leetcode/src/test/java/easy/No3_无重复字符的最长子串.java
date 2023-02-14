package easy;

import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/"></a>
 * <p>
 * 题目：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 注意：此解法比较慢，后续需要优化
 */
public class No3_无重复字符的最长子串 {

    @Test
    public void test1() {
        assert 3 == lengthOfLongestSubstring("abcabcbb");
    }

    @Test
    public void test2() {
        assert 1 == lengthOfLongestSubstring("a");
    }

    @Test
    public void test3() {
        assert 2 == lengthOfLongestSubstring("ab");
    }

    @Test
    public void test4() {
        assert 1 == lengthOfLongestSubstring(" ");
    }

    @Test
    public void test5() {
        assert 3 == lengthOfLongestSubstring("pwwkew");
    }

    @Test
    public void test6() {
        assert 3 == lengthOfLongestSubstring("dvdf");
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        // 记录最长字串的起始索引和长度。
        int maxLength = 0;
        String currentStr = null;
        String beforeChar = null;
        String lastChar = null;
        int repeatCharIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                currentStr = s.substring(i, j);
                beforeChar = currentStr.substring(0, currentStr.length() - 1);
                lastChar = currentStr.substring(currentStr.length() - 1);
                repeatCharIndex = beforeChar.indexOf(lastChar);
                if (repeatCharIndex > -1) {
                    i += repeatCharIndex;
                    break;
                }
                if (currentStr.length() > maxLength) {
                    maxLength = currentStr.length();
                }
            }
        }
        return maxLength;
    }
}

package easy;

import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/longest-common-prefix/"></a>
 */
public class No14_最长公共前缀 {

    @Test
    public void test1() {
        assert "fl".equals(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    @Test
    public void test2() {
        assert "".equals(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int strIndex = 0;
        boolean flagStop = false;
        String strFirst = null;
        String strCurrent = null;
        for (; strIndex < strs[0].length(); strIndex++) {
            for (int i = 0; i < strs.length; i++) {
                // 判断当前字符串是否为空
                if (strs[i].length() == 0) {
                    return "";
                }
                // 只存储第一个字符串
                if (i == 0) {
                    strFirst = strs[i].substring(strIndex, strIndex + 1);
                    continue;
                }
                // 判断是否已经到达某个字符串结尾
                if (strIndex >= strs[i].length()) {
                    flagStop = true;
                    break;
                }
                // 获取当前字符串
                strCurrent = strs[i].substring(strIndex, strIndex + 1);
                if (!strCurrent.equals(strFirst)) {
                    flagStop = true;
                    break;
                }
            }
            if (flagStop) {
                break;
            }
        }
        return strs[0].substring(0, strIndex);
    }
}

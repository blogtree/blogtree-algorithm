package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/"></a>
 */
@Slf4j
public class No1945_字符串转化后的各位数字之和 {

    @Test
    public void test1() {
        assert getLucky("iiii", 1) == 36;
        assert getLucky("leetcode", 2) == 6;
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int getLucky(String s, int k) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            strBuilder.append(ch - 'a' + 1);
        }
        String digits = strBuilder.toString();
        for (int i = 1; i <= k && digits.length() > 1; ++i) {
            int sum = 0;
            for (int j = 0; j < digits.length(); ++j) {
                char ch = digits.charAt(j);
                sum += ch - '0';
            }
            digits = Integer.toString(sum);
        }
        return Integer.parseInt(digits);
    }
}

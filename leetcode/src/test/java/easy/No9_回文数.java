package easy;

import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/palindrome-number/"></a>
 */
public class No9_回文数 {

    @Test
    public void test() {
        assert isPalindrome(121);
        assert !isPalindrome(-121);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}

package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/plus-one/"></a>
 */
@Slf4j
public class No66_加一 {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            if (sum == 10) {
                digits[i] = 0;
                if (i == 0) {
                    // 如果当前已经是第一位了，则需要在前边补1
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    for (int j = 1; j < res.length; j++) {
                        res[j] = digits[j - 1];
                    }
                    return res;
                }
            } else {
                digits[i] = sum;
                break;
            }
        }
        return digits;
    }
}

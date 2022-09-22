package normal;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/reverse-integer/"></a>
 * <p>
 * 题目：将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */
public class No7_整数反转 {

    @Test
    public void test() {
        assert 321 == reverse(123);
        assert -321 == reverse(-123);
        assert 21 == reverse(120);
        assert 0 == reverse(0);
    }

    public int reverse(int x) {
        int minus = 1;
        if (x < 0) {
            minus = -1;
            x *= -1;
        }
        String str = String.valueOf(x);
        String strReverse = new StringBuffer(str).reverse().toString();
        try {
            int xReverse = Integer.valueOf(strReverse);
            return xReverse * minus;
        } catch (Exception e) {
            return 0;
        }
    }
}

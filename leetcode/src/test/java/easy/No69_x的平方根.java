package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/sqrtx/"></a>
 */
@Slf4j
public class No69_x的平方根 {

    @Test
    public void test1() {
        assert mySqrt(0) == 0;
        assert mySqrt(1) == 1;
        assert mySqrt(2) == 1;
        assert mySqrt(3) == 1;
        assert mySqrt(4) == 2;
        assert mySqrt(5) == 2;
        assert mySqrt(6) == 2;
        assert mySqrt(8) == 2;
        assert mySqrt(9) == 3;
        assert mySqrt(15) == 3;
        assert mySqrt(16) == 4;
        assert mySqrt(18) == 4;
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int mySqrt(int x) {
        int lift = 0, right = x, ans = -1;
        while (lift <= right) {
            int mid = lift + (right - lift) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                lift = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

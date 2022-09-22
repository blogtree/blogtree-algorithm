package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/power-of-three/"></a>
 */
@Slf4j
public class No326_3的幂_2 {

    @Test
    public void test1() {
        assert isPowerOfThree(27);
        assert !isPowerOfThree(0);
        assert isPowerOfThree(9);
        assert !isPowerOfThree(45);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return 1162261467 % n == 0;
    }

    @Test
    public void testGenerate() {
        int powerOfThree = 1;
        for (int i = 1; i < 21; i++) {
            powerOfThree *= 3;
            log.info("i={}, powerOfThree={}", i, powerOfThree);
        }
    }
}

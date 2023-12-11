package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/arranging-coins/"></a>
 */
@Slf4j
public class No441_排列硬币 {

    @Test
    public void test1() {
        assert 1 == arrangeCoins(1);
        assert 2 == arrangeCoins(5);
        assert 3 == arrangeCoins(6);
        assert 3 == arrangeCoins(8);
    }

    @Test
    public void test2() {
        assert 65536 == arrangeCoins(2147483647);
    }

    @Test
    public void test3() {
    }


    /**
     * 当n比较大时，此方法比较慢
     */
    public int arrangeCoins(int n) {
        int i = 1;
        long sum = 1;
        while (sum <= n) {
            i++;
            sum += i;
        }
        return i - 1;
    }
}

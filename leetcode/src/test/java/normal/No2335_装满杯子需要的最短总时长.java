package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @see <a href="https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/"></a>
 */
@Slf4j
public class No2335_装满杯子需要的最短总时长 {

    @Test
    public void test1() {
        assert 4 == fillCups(new int[]{1, 4, 2});
    }

    @Test
    public void test2() {
        assert 7 == fillCups(new int[]{5, 4, 4});
    }

    @Test
    public void test3() {
        assert 5 == fillCups(new int[]{5, 0, 0});
        assert 4 == fillCups(new int[]{2, 4, 2});
        assert 8 == fillCups(new int[]{8, 3, 5});
        assert 10 == fillCups(new int[]{7, 9, 4});
        assert 6 == fillCups(new int[]{3, 4, 4});
        assert 12 == fillCups(new int[]{8, 6, 10});
    }

    /**
     * 标签：
     * 分析：
     * 1
     * 2
     * 3
     */
    public int fillCups(int[] amount) {
        Arrays.sort(amount);

        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }

        int second = 0;
        while (amount[2] != 0) {
            if (amount[1] != 0) {
                amount[1]--;
                amount[2]--;
                second++;
            } else {
                amount[2]--;
                second++;
            }
            Arrays.sort(amount);
        }
        return second;
    }
}

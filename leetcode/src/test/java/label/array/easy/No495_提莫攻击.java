package label.array.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/teemo-attacking/"></a>
 */
@Slf4j
public class No495_提莫攻击 {

    @Test
    public void test1() {
        assert 4 == findPoisonedDuration(new int[]{1, 4}, 2);
    }

    @Test
    public void test2() {
        assert 3 == findPoisonedDuration(new int[]{1, 2}, 2);
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 1) {
            return duration;
        }
        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int time = timeSeries[i + 1] - timeSeries[i];
            if (time >= duration) {
                total += duration;
            } else {
                total += time;
            }
        }
        total += duration;
        return total;
    }
}



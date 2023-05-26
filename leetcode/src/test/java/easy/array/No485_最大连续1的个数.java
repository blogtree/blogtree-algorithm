package easy.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/max-consecutive-ones/"></a>
 */
@Slf4j
public class No485_最大连续1的个数 {

    @Test
    public void test1() {
        assert 3 == findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        assert 2 == findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1});

    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
            } else {
                if (current > max) {
                    max = current;
                }
                current = 0;
            }
        }
        if (current > max) {
            max = current;
        }
        return max;
    }
}



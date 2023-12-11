package label.array.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-average-subarray-i/"></a>
 */
@Slf4j
public class No643_子数组最大平均数_1 {

    /**
     * 标签：数组、滑动窗口
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }

    @Test
    public void test1() {
        double maxAverage = findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
        System.out.println(maxAverage);
    }

    @Test
    public void test2() {
        double maxAverage = findMaxAverage(new int[]{5}, 1);
        System.out.println(maxAverage);
    }

    @Test
    public void test3() {
    }


}



import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/maximum-subarray/"></a>
 * <p>
 * 数组 分治 动态规划
 */
@Slf4j
public class No53_最大子数组和 {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：遍历数组
     */
    public int maxSubArray(int[] nums) {
        int tempSum = 0;
        int maxSum = nums[0];
        for (int num : nums) {
            tempSum = Math.max(tempSum + num, num);
            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
        }
        return maxSum;
    }
}

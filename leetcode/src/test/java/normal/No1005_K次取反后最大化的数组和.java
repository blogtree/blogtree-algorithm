package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/"></a>
 */
@Slf4j
public class No1005_K次取反后最大化的数组和 {

    @Test
    public void test1() {
        assert 5 == largestSumAfterKNegations(new int[]{4, 2, 3}, 1);
        assert 6 == largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3);
        assert 13 == largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2);
    }

    @Test
    public void test2() {
        assert 5 == largestSumAfterKNegations(new int[]{-4, -2, -3}, 4);
    }

    @Test
    public void test3() {
    }

    /**
     * 1 对nums进行排序
     * 2 遍历排序后的数组，将负数 修改为 正数，同时k--
     * 3 如果k==0 或 遇到正数时，则停止修改
     * 4 对nums进行排序
     * 5 如果此时k>0 && k为奇数 && 首个元素不为0，则修改首个元素
     * 6 求总和
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0;
        for (; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                nums[i] = num * -1;
                k--;
            }
            if (k == 0 || num >= 0) {
                break;
            }
        }

        Arrays.sort(nums);

        if (k > 0 && k % 2 == 1) {
            if (nums[0] > 0) {
                nums[0] = nums[0] * -1;
            }
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}

package label.array.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-product-of-three-numbers/"></a>
 */
@Slf4j
public class No628_三个数的最大乘积 {

    /**
     * 标签：数组 排序
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[length - 3] * nums[length - 2] * nums[length - 1],
                nums[length - 1] * nums[0] * nums[1]
        );
    }

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }


}



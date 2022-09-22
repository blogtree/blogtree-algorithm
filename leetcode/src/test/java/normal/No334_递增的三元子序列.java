package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/increasing-triplet-subsequence/"></a>
 * <p>
 * 贪心 数组
 */
@Slf4j
public class No334_递增的三元子序列 {

    @Test
    public void test1() {
        assert increasingTriplet(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void test2() {
        assert !increasingTriplet(new int[]{5, 4, 3, 2, 1});
    }

    @Test
    public void test3() {
        assert increasingTriplet(new int[]{2, 1, 5, 0, 4, 6});
    }


    @Test
    public void test4() {
        assert !increasingTriplet(new int[]{1, 2});
        assert increasingTriplet(new int[]{1, 3, 2, 4});
    }

    @Test
    public void test5() {
        assert increasingTriplet(new int[]{1, 2, 1, 3});
    }

    /**
     * 分析：先声明最小的num1和num3，然后遍历数组，找到num3
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int num1 = nums[0];
        int num2 = Integer.MAX_VALUE;
        int num;
        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            if (num > num2) {
                return true;
            }
            if (num > num1) {
                num2 = num;
            } else {
                num1 = num;
            }
        }
        return false;
    }
}

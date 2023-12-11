package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/range-sum-query-immutable/"></a>
 */
@Slf4j
public class No303_区域和检索_数组不可变 {

    @Test
    public void test1() {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assert 1 == numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
        assert -1 == numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
        assert -3 == numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    class NumArray {

        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int sum = 0;
            for (int i = left; i < right + 1; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}

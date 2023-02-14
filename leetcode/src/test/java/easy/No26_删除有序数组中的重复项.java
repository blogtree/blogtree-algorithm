package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/"></a>
 */
@Slf4j
public class No26_删除有序数组中的重复项 {

    @Test
    public void test1() {
        assert 2 == removeDuplicates(new int[]{1, 1, 2});
    }

    @Test
    public void test2() {
        assert 5 == removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

    @Test
    public void test3() {
        assert 5 == removeDuplicates(new int[]{1, 2, 3, 4, 5});
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int lastNumIndex = 0;
        int num;
        for (int i = 1; i < nums.length && lastNumIndex < nums.length; i++) {
            num = nums[i];
            if (num != nums[lastNumIndex]) {
                nums[lastNumIndex + 1] = num;
                lastNumIndex++;
            }
        }
        return lastNumIndex + 1;
    }
}

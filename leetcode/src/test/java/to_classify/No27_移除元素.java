package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/remove-element/"></a>
 */
@Slf4j
public class No27_移除元素 {

    @Test
    public void test1() {
        int[] nums = new int[]{3, 2, 2, 3};
        assert 2 == removeElement(nums, 3);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        assert 5 == removeElement(nums, 2);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1};
        assert 0 == removeElement(nums, 1);
    }

    @Test
    public void test4() {
        int[] nums = new int[]{3, 3};
        assert 0 == removeElement(nums, 3);
    }

    /**
     * 正序遍历数组，如果遇到需要移除的元素，则倒序获取一个元素
     * <p>
     * 注意：倒序获取的元素，不能等于要移除的元素
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int lastIndex = nums.length - 1;
        for (; i < nums.length; i++) {
            if (nums[i] == val) {
                while (lastIndex > -1 && nums[lastIndex] == val) {
                    nums[lastIndex] = 0;
                    lastIndex--;
                }
                if (i < lastIndex) {
                    nums[i] = nums[lastIndex];
                    nums[lastIndex] = 0;
                    lastIndex--;
                } else {
                    break;
                }
            }
        }
        return lastIndex + 1;
    }
}

package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/search-insert-position/"></a>
 * <p>
 * 数组 二分查找
 */
@Slf4j
public class No35_搜索插入位置 {

    @Test
    public void test1() {
        assert 2 == searchInsert(new int[]{1, 3, 5, 6}, 5);
        assert 1 == searchInsert(new int[]{1, 3, 5, 6}, 2);
        assert 4 == searchInsert(new int[]{1, 3, 5, 6}, 7);
        assert 0 == searchInsert(new int[]{1, 3, 5, 6}, 0);
        assert 0 == searchInsert(new int[]{1}, 0);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：通过二分查找来快速定位到
     */
    public int searchInsert(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int mid = (max - min) / 2 + min;
            if (nums[mid] == target) {
                // 直接返回
                return mid;
            } else if (nums[mid] > target) {
                // 大于目标值
                max = mid - 1;
            } else if (nums[mid] < target) {
                // 小于目标值
                min = mid + 1;
            }
        }
        return min;
    }
}

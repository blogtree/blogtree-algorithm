package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/binary-search/"></a>
 */
@Slf4j
public class No704_二分查找 {

    @Test
    public void test1() {
        assert 4 == search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
    }

    @Test
    public void test2() {
        assert -1 == search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
    }

    @Test
    public void test3() {
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int minIndex, int maxIndex) {
        if (maxIndex - minIndex < 2) {
            if (nums[minIndex] == target) {
                return minIndex;
            } else if (nums[maxIndex] == target) {
                return maxIndex;
            } else {
                return -1;
            }
        }
        int middleIndex = (maxIndex + minIndex) / 2;
        int middleNum = nums[middleIndex];
        if (middleNum == target) {
            return middleIndex;
        } else if (middleNum > target) {
            return binarySearch(nums, target, minIndex, middleIndex);
        } else {
            return binarySearch(nums, target, middleIndex, maxIndex);
        }
    }
}

package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/find-peak-element/"></a>
 */
@Slf4j
public class No162_寻找峰值 {

    @Test
    public void test1() {
        assert 2 == findPeakElement(new int[]{1, 2, 3, 1});
        assert 1 == findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
    }

    @Test
    public void test2() {
        assert 1 == findPeakElement(new int[]{1, 2});
    }

    @Test
    public void test3() {
    }

    public int findPeakElement(int[] nums) {
        int num;
        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            if (i == nums.length - 1) {
                if (num > nums[i - 1]) {
                    return i;
                }
            }
            if (num > nums[i - 1] && num > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

}

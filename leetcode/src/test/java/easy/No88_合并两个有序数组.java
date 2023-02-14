package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/merge-sorted-array/"></a>
 */
@Slf4j
public class No88_合并两个有序数组 {

    @Test
    public void test1() {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{1}, 1, new int[]{}, 0);
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    @Test
    public void test2() {
        merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }

    @Test
    public void test3() {
    }

    /**
     * 由于num1的长度为 m+n，所以可以倒叙遍历 num1 和 num2，填充到num1中
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        int i = m + n - 1;
        while (i >= 0) {
            if (n == 0 || (m > 0 && nums1[m - 1] >= nums2[n - 1])) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
            i--;
        }
    }

}

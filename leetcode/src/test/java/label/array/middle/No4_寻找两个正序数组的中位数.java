package label.array.middle;

import org.junit.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/"></a>
 * <p>
 * 题目：给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class No4_寻找两个正序数组的中位数 {

    /**
     * 标签：数组 二分查找 分治
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> totalNums = new LinkedList<Integer>();
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                totalNums.add(nums1[index1++]);
            } else {
                totalNums.add(nums2[index2++]);
            }
        }
        while (index1 < nums1.length) {
            totalNums.add(nums1[index1++]);
        }
        while (index2 < nums2.length) {
            totalNums.add(nums2[index2++]);
        }

        double median = 0;
        if (totalNums.size() % 2 == 0) {
            median = (totalNums.get(totalNums.size() / 2 - 1) + totalNums.get(totalNums.size() / 2)) / 2.0;
        } else {
            median = totalNums.get((totalNums.size() - 1) / 2);
        }
        return median;
    }

    @Test
    public void test1() {
        assert 2 == findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }

    @Test
    public void test2() {
        assert 2.5 == findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

    @Test
    public void test3() {
        assert 0 == findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0});
    }

    @Test
    public void test4() {
        assert 1.0 == findMedianSortedArrays(new int[]{}, new int[]{1});
    }

    @Test
    public void test5() {
        assert 2.0 == findMedianSortedArrays(new int[]{2}, new int[]{});
    }
}

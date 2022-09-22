package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/"></a>
 */
@Slf4j
public class No373_查找和最小的K对数字 {

    @Test
    public void test1() {
        List res = kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        log.info("res={}", res);
    }

    @Test
    public void test2() {
        List res = kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 3);
        log.info("res={}", res);
    }

    @Test
    public void test3() {
        List res = kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
        log.info("res={}", res);
    }

    @Test
    public void test4() {
        List res = kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10);
        log.info("res={}", res);
    }

    /**
     * 分析：遍历num1 num2；如果num1的数值 比 num2的数组大，则使用num1[index1 - 1] 与 num2[index2]求和，num2的索引+1
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(Arrays.asList(nums1[0], nums2[0]));
        int index1 = 1;
        int index2 = 1;
        while (res.size() < k && index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] >= nums2[index2]) {
                res.add(Arrays.asList(nums1[index1 - 1], nums2[index2]));
                index2++;
            } else {
                res.add(Arrays.asList(nums1[index1], nums2[index2 - 1]));
                index1++;
            }
        }
        if (res.size() < k) {
            while (index1 < nums1.length) {
                res.add(Arrays.asList(nums1[index1++], nums2[nums2.length - 1]));
            }
            while (index2 < nums2.length) {
                res.add(Arrays.asList(nums1[nums1.length - 1], nums2[index2++]));
            }
        }
        return res;
    }
}

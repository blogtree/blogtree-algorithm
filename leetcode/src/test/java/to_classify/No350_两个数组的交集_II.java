package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode.cn/problems/intersection-of-two-arrays-ii/"></a>
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 * <p>
 * Tips:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
@Slf4j
public class No350_两个数组的交集_II {

    @Test
    public void test1() {
        assert Arrays.equals(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}), new int[]{2, 2});
        assert Arrays.equals(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}), new int[]{4, 9});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // map存储最少的数据
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            Integer count = nums1Map.get(num);
            if (count == null) {
                nums1Map.put(num, 1);
            } else {
                nums1Map.put(num, count + 1);
            }
        }

        List<Integer> resultList = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            Integer count = nums1Map.get(num);
            if (count == null || count == 0) {
                continue;
            } else {
                resultList.add(num);
                nums1Map.put(num, count - 1);
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}

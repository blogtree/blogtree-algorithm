import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays/"></a>
 */
@Slf4j
public class No349_两个数组的交集 {

    @Test
    public void test1() {
        assert Arrays.equals(new int[]{2}, intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    @Test
    public void test2() {
        assert Arrays.equals(new int[]{4, 9}, intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

    @Test
    public void test3() {
        assert Arrays.equals(new int[]{}, intersection(new int[]{1}, new int[]{2}));
    }

    @Test
    public void test4() {
        assert Arrays.equals(new int[]{3}, intersection(new int[]{1, 2, 3}, new int[]{3}));
    }

    /**
     * 分析：
     * 1 两个数组先排序
     * 2 利用双指针遍历两个数组，如果值相等则表示交集
     * 3 不相等，则数据较小的索引+1
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet();
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1 == num2) {
                set.add(num1);
                index1++;
                index2++;
            } else if (num1 > num2) {
                index2++;
            } else if (num1 < num2) {
                index1++;
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}

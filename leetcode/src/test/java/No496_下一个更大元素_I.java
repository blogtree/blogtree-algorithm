import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode-cn.com/problems/next-greater-element-i/"></a>
 */
@Slf4j
public class No496_下一个更大元素_I {

    @Test
    public void test1() {
        int[] res = nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        log.info(Arrays.toString(res));
    }

    @Test
    public void test2() {
        int[] res = nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
        log.info(Arrays.toString(res));
    }

    @Test
    public void test3() {
        int[] res = nextGreaterElement(new int[]{2, 1}, new int[]{1, 2});
        log.info(Arrays.toString(res));
    }

    @Test
    public void test4() {
        int[] res = nextGreaterElement(new int[]{1}, new int[]{1});
        log.info(Arrays.toString(res));
    }

    /**
     * 1 遍历nums2
     * 1-1 用list来存储还未找到下一个更大数的数字
     * 1-2 如果找到下一个最大数字，用map这个数字 和 它的下一个更大数。
     * <p>
     * 2 遍历nums1，直接查找下一个更大的数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 存储nums2的数字 和 下一个它更大的数
        Map<Integer, Integer> num2Map = new HashMap<>(nums2.length);

        // 存储还未找到下一个更大数的数字
        List<Integer> noNextList = new LinkedList<>();
        noNextList.add(nums2[0]);

        for (int i = 1; i < nums2.length; i++) {
            int num = nums2[i];
            Iterator<Integer> iterator = noNextList.iterator();
            while (iterator.hasNext()) {
                Integer item = iterator.next();
                if (num > item) {
                    num2Map.put(item, num);
                    iterator.remove();
                }
            }
            noNextList.add(num);
        }

        Integer next;
        for (int i = 0; i < nums1.length; i++) {
            next = num2Map.get(nums1[i]);
            nums1[i] = (next == null) ? -1 : next;
        }
        return nums1;
    }
}

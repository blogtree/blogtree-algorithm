package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/"></a>
 *
 * 数组 双指针 二分查找
 */
@Slf4j
public class No167_两数之和_II_输入有序数组 {

    @Test
    public void test1() {
        assert Arrays.equals(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2});
        assert Arrays.equals(twoSum(new int[]{2, 3, 4}, 6), new int[]{1, 3});
        assert Arrays.equals(twoSum(new int[]{-1, 0}, -1), new int[]{1, 2});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：
     * 1 从第一个数开始，通过二分法，先去找另外一个数，找到则直接返回。
     * 2 找不到，则从第二个数开始。
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int one = numbers[i];
            int two = target - one;
            Integer twoIndex = indexOf(numbers, two, i + 1, numbers.length - 1);
            if (twoIndex != null) {
                answer[0] = i + 1;
                answer[1] = twoIndex + 1;
                break;
            }
        }
        return answer;
    }

    /**
     * 二分查找某个数值在数组中的位置
     */
    private Integer indexOf(int[] numbers, int two, int start, int end) {
        if (start > end || end > numbers.length - 1) {
            return null;
        }
        int mid = (start + end) / 2;
        int midVal = numbers[mid];
        if (midVal > two) {
            return indexOf(numbers, two, start, mid - 1);
        } else if (midVal < two) {
            return indexOf(numbers, two, mid + 1, end);
        } else {
            return mid;
        }
    }
}

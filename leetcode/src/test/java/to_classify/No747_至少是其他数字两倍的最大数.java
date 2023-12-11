package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/"></a>
 * <p>
 * 数组 排序
 */
@Slf4j
public class No747_至少是其他数字两倍的最大数 {

    @Test
    public void test1() {
        assert 1 == dominantIndex(new int[]{3, 6, 1, 0});
        assert -1 == dominantIndex(new int[]{1, 2, 3, 4});
        assert 0 == dominantIndex(new int[]{1});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：声明四个int值，用来存储当前最大值、第二大的值 及其索引；遍历数组；比较最大值 和 第二大的值
     */
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int maxIndex = nums[0] > nums[1] ? 0 : 1;
        int maxValue = nums[maxIndex];
        int secondMaxIndex = nums[0] < nums[1] ? 0 : 1;
        int secondMaxValue = nums[secondMaxIndex];
        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            if (num > maxValue) {
                secondMaxValue = maxValue;
                secondMaxIndex = maxIndex;
                maxValue = num;
                maxIndex = i;
            } else if (num > secondMaxValue) {
                secondMaxValue = num;
                secondMaxIndex = i;
            }
        }
        if (maxValue >= secondMaxValue * 2) {
            return maxIndex;
        } else {
            return -1;
        }
    }
}

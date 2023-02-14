package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/"></a>
 */
@Slf4j
public class No1984_学生分数的最小差值 {

    @Test
    public void test1() {
        assert 0 == minimumDifference(new int[]{90}, 1);
    }

    @Test
    public void test2() {
        assert 2 == minimumDifference(new int[]{9, 4, 1, 7}, 2);
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：数组 排序 滑动窗口
     * 分析：先排序，后利用双指针遍历数组，找到 最高分 和 最低分 的 最小差值
     *
     */
    public int minimumDifference(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int diff = nums[i + k - 1] - nums[i];
            if (diff < min) {
                min = diff;
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}

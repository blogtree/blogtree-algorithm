package easy.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/array-partition/"></a>
 */
@Slf4j
public class No561_数组拆分 {

    @Test
    public void test1() {
        assert 4 == arrayPairSum(new int[]{1, 4, 3, 2});
    }

    @Test
    public void test2() {
        assert 9 == arrayPairSum(new int[]{6, 2, 6, 5, 1, 2});
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[i * 2];
        }
        return sum;
    }
}



import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/"></a>
 */
@Slf4j
public class No453_最小操作次数使数组元素相等 {

    @Test
    public void test1() {
        assert 3 == minMoves(new int[]{1, 2, 3});
        assert 0 == minMoves(new int[]{1, 1, 1,});
        assert 0 == minMoves(new int[]{1});
        assert 4 == minMoves(new int[]{1, 2, 4});
        assert 4 == minMoves(new int[]{2, 2, 6});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }


    /**
     * 思路：
     * 1 每次操作将会使 n - 1 个元素增加 1 = 每次操作有一个数 减少1
     * 2 遍历求最小值
     * 3 遍历 所有数 - 最小值的总和
     */
    public int minMoves(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int min = nums[0];
        int num;
        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            if (min > num) {
                min = num;
            }
        }

        int sum = 0;
        for (int num1 : nums) {
            sum += num1 - min;
        }
        return sum;
    }
}

package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @see <a href="https://leetcode-cn.com/problems/move-zeroes/"></a>
 */
@Slf4j
public class No283_移动零 {

    @Test
    public void test1() {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        int[] res = new int[]{1, 3, 12, 0, 0};
        moveZeroes(arr);
        assert Arrays.equals(arr, res);
    }

    @Test
    public void test2() {
        int[] arr = new int[]{0};
        int[] res = new int[]{0};
        moveZeroes(arr);
        assert Arrays.equals(arr, res);
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：
     * 1 设置一个先入先出的队列（用来存储为=0的位置）
     * 2 遍历一次数组，遇到0则添加到队列中，
     */
    public void moveZeroes(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                queue.add(i);
            } else {
                if (queue.size() != 0) {
                    int zeroIndex = queue.poll();
                    nums[zeroIndex] = num;
                    nums[i] = 0;
                    queue.add(i);
                }
            }
        }
    }
}

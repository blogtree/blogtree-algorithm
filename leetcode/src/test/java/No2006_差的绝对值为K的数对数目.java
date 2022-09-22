import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/"></a>
 */
@Slf4j
public class No2006_差的绝对值为K的数对数目 {

    @Test
    public void test1() {
        assert 4 == countKDifference(new int[]{1, 2, 2, 1}, 1);
        assert 0 == countKDifference(new int[]{1, 3}, 3);
        assert 3 == countKDifference(new int[]{3, 2, 1, 5, 4}, 2);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：|nums[i] - nums[j]| == k      等价于     nums[i] == nums[j] + k  或者  nums[i] == nums[j] - k
     * 1 遍历数组
     * 2 用map存储 出现过数字和 出现次数
     * 3 从第二个数字开始，从map中查找符合条件的数字
     * 4 对符合条件的数字，进行累加
     */
    public int countKDifference(int[] nums, int k) {
        if (nums.length <= 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(nums[0], 1);
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int num1 = num + k;
            if (map.containsKey(num1)) {
                sum += map.get(num1);
            }
            int num2 = num - k;
            if (map.containsKey(num2)) {
                sum += map.get(num2);
            }
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return sum;
    }
}

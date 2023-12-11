package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode-cn.com/problems/contains-duplicate-ii/"></a>
 *
 * 数组 哈希表 滑动窗口
 */
@Slf4j
public class No219_存在重复元素_II {

    @Test
    public void test1() {
        assert containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
        assert containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
        assert !containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：
     * 1 遍历数组
     * 2 从当前元素之后，再遍历k个节点，如果相等则返回true（注意数组不要越界）
     * 3 如果一直没有相等，则返回false
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}

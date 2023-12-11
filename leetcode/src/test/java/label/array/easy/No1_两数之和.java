package label.array.easy;

import org.blogtree.algorithm.base.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode-cn.com/problems/two-sum/"></a>
 */
public class No1_两数之和 extends BaseTest {


    /**
     * 标签：数组、哈希表
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int currentVal = nums[i];
            int otherVal = target - currentVal;
            Integer otherIndex = map.get(otherVal);
            if (otherIndex != null) {
                if (i < otherIndex) {
                    return new int[]{i, otherIndex};
                } else {
                    return new int[]{otherIndex, i};
                }
            }
            map.put(currentVal, i);
        }
        return new int[]{};
    }

    @Test
    public void test1() {
        int[] res = twoSum(new int[]{2, 7, 11, 15}, 9);
        log.info("res={}", res);
    }

}

package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;

/**
 * @see <a href="https://leetcode-cn.com/problems/contains-duplicate/"></a>
 */
@Slf4j
public class No217_存在重复元素 {

    @Test
    public void test1() {
        assert containsDuplicate(new int[]{1, 2, 3, 1});
        assert containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
        assert !containsDuplicate(new int[]{1, 2, 3, 4});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：利用HashSet对元素做去重
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
            if (hashSet.size() < i + 1) {
                return true;
            }
        }
        return false;
    }
}

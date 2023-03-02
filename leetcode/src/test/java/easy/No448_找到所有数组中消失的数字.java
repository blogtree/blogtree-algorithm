package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/"></a>
 */
@Slf4j
public class No448_找到所有数组中消失的数字 {

    @Test
    public void test1() {
        List<Integer> list = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        List<Integer> listRight = Arrays.asList(5, 6);
        assert list.equals(listRight);
    }

    @Test
    public void test2() {
        List<Integer> list = findDisappearedNumbers(new int[]{1,1});
        List<Integer> listRight = Arrays.asList(2);
        assert list.equals(listRight);
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：数组 哈希表
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            numSet.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numSet.remove(num);
        }
        return new ArrayList<>(numSet);
    }
}

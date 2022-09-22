package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;

/**
 * @see <a href="https://leetcode-cn.com/problems/single-number/"></a>
 */
@Slf4j
public class No136_只出现一次的数字 {

    @Test
    public void test1() {
        assert 1 == singleNumber(new int[]{2, 2, 1});
        assert 4 == singleNumber(new int[]{4, 1, 2, 1, 2});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 题目：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 分析：用一个 HashSet 存储第一次出现的数字，当它第二次出现时，则从这里移除。
     * 1
     * 2
     * 3
     */
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                hashSet.remove(num);
            } else {
                hashSet.add(num);
            }
        }
        return hashSet.iterator().next();
    }
}

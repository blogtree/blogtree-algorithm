import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/majority-element/"></a>
 */
@Slf4j
public class No169_多数元素 {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

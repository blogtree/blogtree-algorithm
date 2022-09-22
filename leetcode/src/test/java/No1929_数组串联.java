import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/concatenation-of-array/"></a>
 */
@Slf4j
public class No1929_数组串联 {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：遍历一次数组，设置两个值
     */
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }
}

package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/missing-number/"></a>
 */
@Slf4j
public class No268_丢失的数字 {

    @Test
    public void test1() {
        assert 2 == missingNumber(new int[]{3, 0, 1});
        assert 2 == missingNumber(new int[]{0, 1});
        assert 1 == missingNumber(new int[]{0});
        assert 0 == missingNumber(new int[]{1});
        assert 8 == missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 创建一个 n+1长的数组 flagArr
     * 遍历nums，设置flagArr对应节点的值为1
     * 遍历flagArr，值为0的，则为缺失的数字
     */
    public int missingNumber(int[] nums) {
        int[] flagArr = new int[nums.length + 1];
        for (int num : nums) {
            flagArr[num] = 1;
        }
        for (int i = 0; i < flagArr.length; i++) {
            if (flagArr[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}

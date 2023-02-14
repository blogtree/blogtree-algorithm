package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/range-addition-ii/"></a>
 */
@Slf4j
public class No598_范围求和_II {

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
     * 分析：
     * ops的长度，就是最大的数值
     * 都为最大数的值，能组成一个长方形或正方形
     * 求x、y的最大值
     * maxCount = x * y
     */
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0 || ops[0].length == 0) {
            return m * n;
        }

        // 遍历第一行，求最小值
        int xMin = m;
        int yMin = n;
        for (int[] op : ops) {
            xMin = Math.min(xMin, op[0]);
            yMin = Math.min(yMin, op[1]);
        }
        int maxCount = xMin * yMin;
        return maxCount;
    }

}

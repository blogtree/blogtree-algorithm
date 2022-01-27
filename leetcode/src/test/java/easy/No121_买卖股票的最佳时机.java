package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/"></a>
 */
@Slf4j
public class No121_买卖股票的最佳时机 {

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
     * 分析：记录之前的最低点，然后假设今天卖掉会赚多少，然后记录最大收益
     */
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int today = prices[i];
            if (today - min > maxProfit) {
                maxProfit = today - min;
            }
            if (today < min) {
                min = today;
            }
        }
        return maxProfit;
    }
}

package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/ipo/"></a>
 */
@Slf4j
public class No502_IPO {

    @Test
    public void test1() {
        assert 4 == findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
    }

    @Test
    public void test2() {
        assert 0 == findMaximizedCapital(1, 0, new int[]{1, 2, 3}, new int[]{1, 1, 2});
    }

    @Test
    public void test3() {
        assert 0 == findMaximizedCapital(1, 0, new int[]{1, 3, 2}, new int[]{1, 3, 2});
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int sum = w;
        List<Integer> profitsList = new LinkedList<>();
        List<Integer> capitalList = new LinkedList<>();
        for (int i = 0; i < profits.length; i++) {
            profitsList.add(profits[i]);
            capitalList.add(capital[i]);
        }

        while (k > 0) {
            // 查找当前能获取到的最大利润
            int maxProfits = 0;
            int maxProfitsIndex = -1;
            for (int i = 0; i < profitsList.size(); i++) {
                int profit = profitsList.get(i);
                int capitalNum = capitalList.get(i);
                if (profit > maxProfits && sum >= capitalNum) {
                    maxProfits = profit;
                    maxProfitsIndex = i;
                }
            }

            if (maxProfitsIndex > -1) {
                // 如果存在最大利润值，则累加
                sum += maxProfits;
                profitsList.remove(maxProfitsIndex);
                capitalList.remove(maxProfitsIndex);
                k--;
            } else {
                // 如果不存在最大利润值，则退出
                break;
            }
        }
        return sum;
    }
}

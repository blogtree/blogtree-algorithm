package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/water-bottles/"></a>
 */
@Slf4j
public class No1518_换酒问题 {

    @Test
    public void test1() {
        assert 13 == numWaterBottles(9, 3);
        assert 19 == numWaterBottles(15, 4);
        assert 6 == numWaterBottles(5, 5);
        assert 2 == numWaterBottles(2, 3);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 1 首次购买的酒瓶，直接加在总瓶数上
     * 2 上次购买的酒瓶 + 上次剩余的酒瓶 / 兑换1瓶的数量 = 本次购买的酒瓶（向下取整）
     * 3 本次购买的酒瓶，加在总瓶数上
     * 4 直到 剩余酒瓶数 < 兑换1瓶的数量
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int emptyNum = total;
        while (emptyNum >= numExchange) {
            int surplus = emptyNum % numExchange;
            int newCount = (emptyNum - surplus) / numExchange;
            total += newCount;
            emptyNum = newCount + surplus;
        }
        return total;
    }
}

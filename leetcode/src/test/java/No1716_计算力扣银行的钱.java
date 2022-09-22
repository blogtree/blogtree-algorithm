import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank/"></a>
 * <p>
 * 数学
 */
@Slf4j
public class No1716_计算力扣银行的钱 {

    @Test
    public void test1() {
        assert 10 == totalMoney(4);
        assert 37 == totalMoney(10);
        assert 96 == totalMoney(20);
        assert 1 == totalMoney(1);
        assert 3 == totalMoney(2);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：第一天数量为1；每隔1天数量+1，每隔7天数量-5；累加n天
     */
    public int totalMoney(int n) {
        int sum = 0;
        int todayNum = 1;
        for (int i = 1; i <= n; i++) {
            sum += todayNum;
            // 计算明天的数量
            if (i % 7 == 0) {
                todayNum -= 5;
            } else {
                todayNum++;
            }
        }
        return sum;
    }
}

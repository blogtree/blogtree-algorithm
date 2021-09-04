package sword_to_offer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/"></a>
 */
@Slf4j
public class No10_1_斐波那契数列 {

    @Test
    public void test1() {
        assert 1 == fib(2);
        assert 2 == fib(3);
        assert 3 == fib(4);
        assert 5 == fib(5);
        assert 8 == fib(6);
        assert 8 == fib(6);
    }

    @Test
    public void test2() {
        assert 134903163 == fib(45);
    }

    @Test
    public void test3() {
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int num1 = 0;
        int num2 = 1;
        int numN = 0;
        int MOD = 1000000007;
        for (int i = 2; i < n + 1; i++) {
            numN = (num1 + num2) % MOD;
            num1 = num2;
            num2 = numN;
        }
        return numN;
    }

}

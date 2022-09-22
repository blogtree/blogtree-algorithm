package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/climbing-stairs/"></a>
 */
@Slf4j
public class No70_爬楼梯 {

    @Test
    public void test1() {
        assert 1 == climbStairs(1);
        assert 2 == climbStairs(2);
        assert 3 == climbStairs(3);
        assert 5 == climbStairs(4);
        assert 8 == climbStairs(5);
        assert 13 == climbStairs(6);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：
     * 分析：
     * 1
     * 2
     * 3
     */
    public int climbStairs(int n) {
        if (n < 4) {
            return n;
        }
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        for (int i = 3; i <= n; i++) {
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
        return num3;
        // 递归超时了
//        if (n < 4) {
//            return n;
//        }
//        return climbStairs(n - 2) + climbStairs(n - 1);
    }
}

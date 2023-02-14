package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/integer-replacement/"></a>
 */
@Slf4j
public class No397_整数替换 {

    @Test
    public void test1() {
        assert 0 == integerReplacement(1);
        assert 1 == integerReplacement(2);
        assert 2 == integerReplacement(3);
        assert 2 == integerReplacement(4);
        assert 4 == integerReplacement(7);
        assert 3 == integerReplacement(8);
        assert 17 == integerReplacement(65535);
    }

    @Test
    public void test2() {
        assert 8 == integerReplacement(100);
    }

    @Test
    public void test3() {
        assert 32 == integerReplacement(Integer.MAX_VALUE);
        assert 32 == integerReplacement(Integer.MAX_VALUE - 1);
    }

    public int integerReplacement(long n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }
}

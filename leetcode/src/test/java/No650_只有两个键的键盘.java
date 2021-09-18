import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/2-keys-keyboard/"></a>
 */
@Slf4j
public class No650_只有两个键的键盘 {

    @Test
    public void test1() {
        assert minSteps(1) == 0;
        assert minSteps(2) == 2;
        assert minSteps(3) == 3;
        assert minSteps(4) == 4;
        assert minSteps(5) == 5;
        assert minSteps(6) == 5;
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return i + minSteps(n / i);
            }
        }
        return n;
    }
}

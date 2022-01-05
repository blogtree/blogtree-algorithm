import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/add-digits/"></a>
 */
@Slf4j
public class No258_各位相加_2 {

    @Test
    public void test() {
        for (int i = 1; i < 1000; i++) {
            log.info("i = {}, res1 = {}, res2 = {}", i, addDigits1(i), addDigits2(i));
        }
    }

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int addDigits1(int num) {
        while (num > 9) {
            num = calculate(num);
        }
        return num;
    }

    public int addDigits2(int num) {
        if (num < 10) {
            return num;
        }
        return (num - 10) % 9 + 1;
    }

    private int calculate(int num) {
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += Character.digit(c, 10);
        }
        return sum;
    }
}

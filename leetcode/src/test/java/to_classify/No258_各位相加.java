package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/add-digits/"></a>
 */
@Slf4j
public class No258_各位相加 {

    @Test
    public void test() {
        for (int i = 1; i < 100; i++) {
            log.info("i = {}, res = {}", i, addDigits(i));
        }
    }

    @Test
    public void test1() {
        assert 2 == addDigits(11);
        assert 2 == addDigits(38);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：略
     */
    public int addDigits(int num) {
        while (num > 9) {
            num = calculate(num);
        }
        return num;
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

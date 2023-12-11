package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/roman-to-integer/description/"></a>
 */
@Slf4j
public class No13_罗马数字转整数 {

    @Test
    public void test1() {
        assert romanToInt("III") == 3;
        assert romanToInt("IV") == 4;
        assert romanToInt("IX") == 9;
        assert romanToInt("LVIII") == 58;
        assert romanToInt("MCMXCIV") == 1994;
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int romanToInt(String s) {
        int sum = 0;
        int before = 0;
        int num;
        for (int i = 0; i < s.length(); i++) {
            num = getValue(s.charAt(i));
            if (before != 0 && before < num) {
                sum = sum - before + (num - before);
            } else {
                sum = sum + num;
            }
            before = num;
        }
        return sum;
    }

    public int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

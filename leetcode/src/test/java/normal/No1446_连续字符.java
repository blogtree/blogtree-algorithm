package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/consecutive-characters/"></a>
 */
@Slf4j
public class No1446_连续字符 {

    @Test
    public void test1() {
        assert 1 == maxPower("a");
        assert 1 == maxPower("tourist");
        assert 2 == maxPower("leetcode");
        assert 5 == maxPower("abbcccddddeeeeedcba");
        assert 5 == maxPower("triplepillooooow");
        assert 11 == maxPower("hooraaaaaaaaaaay");
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int maxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int maxPower = 1;
        char[] chars = s.toCharArray();
        int tempPower = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                tempPower++;
                if (tempPower > maxPower) {
                    maxPower = tempPower;
                }
            } else {
                tempPower = 1;
            }
        }
        return maxPower;
    }
}

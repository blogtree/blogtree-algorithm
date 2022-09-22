package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/nim-game/"></a>
 */
@Slf4j
public class No292_Nim游戏 {

    @Test
    public void test1() {
        assert canWinNim(1);
        assert !canWinNim(4);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}

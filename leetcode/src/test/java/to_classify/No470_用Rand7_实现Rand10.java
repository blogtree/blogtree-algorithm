package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @see <a href="https://leetcode-cn.com/problems/implement-rand10-using-rand7/"></a>
 */
@Slf4j
public class No470_用Rand7_实现Rand10 {

    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            log.info("{}", rand10());
        }
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int rand10() {
        int rand = 0;
        while (true) {
            rand = (rand7() - 1) * 7 + rand7();
            if (rand <= 40) {
                return rand % 10 + 1;
            }
        }
    }

    public int rand7() {
        Random random = new Random();
        int i = random.nextInt(7);
        return i + 1;
    }

}

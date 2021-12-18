package jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class IntegerTest {

    /**
     * 验证：int的除法，都是向下取整的
     */
    @Test
    public void division() {
        log.info("{}", 1 / 3);
        log.info("{}", 2 / 3);
        log.info("{}", 3 / 3);
        log.info("{}", 4 / 3);
        log.info("{}", 5 / 3);
        log.info("{}", 6 / 3);
        // [main] INFO jdk.IntegerTest - 0
        // [main] INFO jdk.IntegerTest - 0
        // [main] INFO jdk.IntegerTest - 1
        // [main] INFO jdk.IntegerTest - 1
        // [main] INFO jdk.IntegerTest - 1
        // [main] INFO jdk.IntegerTest - 2
    }
}

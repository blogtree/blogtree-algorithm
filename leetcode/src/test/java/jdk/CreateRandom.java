package jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

@Slf4j
public class CreateRandom {

    @Test
    public void createByRandom() {
        // 生成0-9之间的随机数
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            log.info("i={}", r.nextInt(10));
        }
    }

    @Test
    public void createByRandomWrong() {
        // 生成0-9之间的随机数
        for (int i = 0; i < 10; i++) {
            Random r = new Random(1);
            log.info("i={}", r.nextInt(10));
        }
    }

    @Test
    public void createByMath() {
        // 生成0-9之间的随机数
        int min = 0, max = 10;
        for (int i = 0; i < 10; i++) {
            // 生成 [0.00,1.0) 的 double数值
            double r = Math.random();
            // 生成随机数
            log.info("i={}", (int) (r * (max - min) + min));
        }
    }
}

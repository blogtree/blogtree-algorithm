package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/simplified-fractions/"></a>
 */
@Slf4j
public class No1447_最简分数 {

    @Test
    public void test1() {
        log.info("res={}", simplifiedFractions(1));
        log.info("res={}", simplifiedFractions(2));
        log.info("res={}", simplifiedFractions(3));
        log.info("res={}", simplifiedFractions(4));
        log.info("res={}", simplifiedFractions(5));
        log.info("res={}", simplifiedFractions(6));
    }

    @Test
    public void test2() {
        log.info("res={}", simplifiedFractions(100));
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：数字 字符串 数论
     * 分析：最简分数特点：分子和分母的最大公倍数为1
     */
    public List<String> simplifiedFractions(int n) {
        if (n == 1) {
            return Collections.EMPTY_LIST;
        }
        List<String> res = new LinkedList();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (isSimple(j, i)) {
                    res.add(j + "/" + i);
                }
            }
        }
        return res;
    }

    /**
     * 判断是否为最简分数
     *
     * @param numerator   分子
     * @param denominator 分母
     */
    private boolean isSimple(int numerator, int denominator) {
        for (int i = numerator; i > 1; i--) {
            if (denominator % i == 0 && numerator % i == 0) {
                return false;
            }
        }
        return true;
    }
}

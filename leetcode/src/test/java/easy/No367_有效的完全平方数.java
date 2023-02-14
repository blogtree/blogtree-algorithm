package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/valid-perfect-square/"></a>
 */
@Slf4j
public class No367_有效的完全平方数 {

    @Test
    public void printAllPerfectSquare() {
        int i = 1;
        long square = 1;
        List<Long> list = new LinkedList<>();
        while (square < Integer.MAX_VALUE && square > 0) {
            square = i * i;
            log.info("i={}, square={}", i, square);
            i++;
            list.add(square);
        }
    }

    @Test
    public void test1() {
        assert !isPerfectSquare(3);
        assert isPerfectSquare(4);
        assert !isPerfectSquare(15);
        assert isPerfectSquare(16);
        assert !isPerfectSquare(2146376240);
        assert isPerfectSquare(2146376241);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        for (int i = 1; i <= num / 2; i++) {
            if (num == i * i) {
                return true;
            }
        }
        return false;
    }
}

package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/valid-perfect-square/"></a>
 */
@Slf4j
public class No367_有效的完全平方数_2 {


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

    private static List<Integer> list = new LinkedList<>();

    static {
        int i = 1;
        int square = 1;
        while (square < Integer.MAX_VALUE && square > 0) {
            square = i * i;
            i++;
            list.add(square);
        }
    }

    public boolean isPerfectSquare(int num) {
        return list.contains(num);
    }
}

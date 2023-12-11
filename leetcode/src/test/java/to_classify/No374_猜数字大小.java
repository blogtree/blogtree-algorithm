package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/guess-number-higher-or-lower/"></a>
 */
@Slf4j
public class No374_猜数字大小 {

    private int pickNumber;

    @Test
    public void test1() {
        pickNumber = 6;
        assert pickNumber == guessNumber(10);
    }

    @Test
    public void test2() {
        pickNumber = 1;
        assert pickNumber == guessNumber(1);
    }

    @Test
    public void test3() {
        pickNumber = 1;
        assert pickNumber == guessNumber(2);
    }

    @Test
    public void test4() {
        pickNumber = 2;
        assert pickNumber == guessNumber(2);
    }

    /**
     * 分析：利用二分法 进行查找
     */
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 1) {
                // pickNumber > mid
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    int guess(int num) {
        if (pickNumber > num) {
            return 1;
        } else if (pickNumber < num) {
            return -1;
        } else {
            return 0;
        }
    }
}

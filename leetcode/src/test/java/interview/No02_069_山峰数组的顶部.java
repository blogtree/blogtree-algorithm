package interview;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/B1IidL/"></a>
 */
@Slf4j
public class No02_069_山峰数组的顶部 {

    @Test
    public void test1() {
        assert 1 == peakIndexInMountainArray(new int[]{0, 1, 0});
    }

    @Test
    public void test2() {
        assert 2 == peakIndexInMountainArray(new int[]{1, 3, 5, 4, 2});
    }

    @Test
    public void test3() {
        assert 1 == peakIndexInMountainArray(new int[]{0, 10, 5, 2});
    }

    @Test
    public void test4() {
        assert 2 == peakIndexInMountainArray(new int[]{3, 4, 5, 1});
    }

    @Test
    public void test5() {
        assert 2 == peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19});
    }

    @Test
    public void test6() {
        assert 5 == peakIndexInMountainArray(new int[]{18, 29, 38, 59, 98, 100, 99, 98, 90});
    }

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            int left = arr[i - 1];
            int mid = arr[i];
            int right = arr[i + 1];
            if (mid > left && mid > right) {
                return i;
            }
        }
        return 1;
    }
}

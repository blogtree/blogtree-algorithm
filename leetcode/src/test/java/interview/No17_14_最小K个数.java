package interview;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/smallest-k-lcci/"></a>
 */
@Slf4j
public class No17_14_最小K个数 {

    @Test
    public void test1() {
        int[] mins = smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int[] smallestK(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[]{};
        }
        if (k >= arr.length) {
            return arr;
        }
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

}

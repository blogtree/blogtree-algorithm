package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @see <a href="https://leetcode-cn.com/problems/random-pick-with-weight/"></a>
 */
@Slf4j
public class No528_按权重随机选择 {

    @Test
    public void test1() {
        Solution obj = new Solution(new int[]{1, 3});
        int param_1 = obj.pickIndex();
        int param_2 = obj.pickIndex();
        int param_3 = obj.pickIndex();
        int param_4 = obj.pickIndex();
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    class Solution {

        private int[] arr;

        private Random r;

        public Solution(int[] w) {
            for (int i = 1; i < w.length; i++) {
                w[i] = w[i] + w[i - 1];
            }
            arr = w;
            r = new Random();
        }

        public int pickIndex() {
            if (arr.length == 1) {
                return 0;
            }
            int ran = r.nextInt(arr[arr.length - 1]);
            return binarySearch(ran);
        }

        private int binarySearch(int num) {
            int min = 0;
            int max = arr.length - 1;
            int mid = 0;
            while (min < max) {
                mid = (max - min) / 2 + min;
                if (arr[mid] > num) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return min;
        }
    }
}

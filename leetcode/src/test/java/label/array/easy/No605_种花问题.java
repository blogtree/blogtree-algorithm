package label.array.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/can-place-flowers/"></a>
 */
@Slf4j
public class No605_种花问题 {

    /**
     * 标签：数组
     * <p>
     * 1 <= flowerbed.length <= 2 * 104
     * flowerbed[i] 为 0 或 1
     * flowerbed 中不存在相邻的两朵花
     * 0 <= n <= flowerbed.length
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return true;
        }
        int left = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int right = 0;
            if (i < flowerbed.length - 1) {
                right = flowerbed[i + 1];
            }
            if (flowerbed[i] == 0 && left == 0 && right == 0) {
                n--;
                flowerbed[i] = 1;
            }
            if (n <= 0) {
                return true;
            }
            left = flowerbed[i];
        }
        return false;
    }

    @Test
    public void test1() {
        assert canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1);
    }

    @Test
    public void test2() {
        assert canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2);
    }

    @Test
    public void test3() {
    }


}



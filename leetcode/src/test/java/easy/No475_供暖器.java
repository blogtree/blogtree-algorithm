package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/heaters/"></a>
 */
@Slf4j
public class No475_供暖器 {

    @Test
    public void test1() {
        assert 1 == findRadius(new int[]{1, 2, 3}, new int[]{2});
    }

    @Test
    public void test2() {
        assert 1 == findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
    }

    @Test
    public void test3() {
        assert 3 == findRadius(new int[]{1, 5}, new int[]{2});
    }

    @Test
    public void test4() {
        assert 5 == findRadius(new int[]{1, 5}, new int[]{6});
    }

    @Test
    public void test5() {
        assert 5 == findRadius(new int[]{1, 5}, new int[]{6, 10});
    }

    @Test
    public void test6() {
        assert 2 == findRadius(new int[]{3, 4}, new int[]{1, 2});
    }

    @Test
    public void test7() {
        assert 104745341 == findRadius(new int[]{474833169, 264817709, 998097157, 817129560}, new int[]{197493099, 404280278, 893351816, 505795335});
    }

    /**
     * 分析：找到每个房屋最近的供暖器距离；然后从这些距离中，找到最大值
     * 步骤：
     * 1 对 houses heaters 进行排序
     * 2 遍历 houses，找到最近的供暖器距离，存储到列表中
     * 3 遍历上一步的列表，找到最大值
     * <p>
     * 优化：
     * 如果 heaters的最小值 > houses的最大值，则结果 = heaters的最小值 - houses的最小值
     * 如果 heaters的最大值 < houses的最小值，则结果 = houses的最大值 - heaters的最大值
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        if (heaters[0] > houses[houses.length - 1]) {
            return heaters[0] - houses[0];
        }
        if (heaters[heaters.length - 1] < houses[0]) {
            return houses[houses.length - 1] - heaters[heaters.length - 1];
        }

        int[] radiusArr = new int[houses.length];

        int j = 0;
        for (int i = 0; i < houses.length; i++) {
            int house = houses[i];
            while (j < heaters.length - 1 && house > heaters[j]) {
                j++;
            }
            if (j == 0) {
                radiusArr[i] = Math.abs(heaters[j] - house);
            } else {
                radiusArr[i] = Math.min(Math.abs(house - heaters[j - 1]), Math.abs(heaters[j] - house));
            }
        }

        int maxRaius = 0;
        for (int i : radiusArr) {
            if (i > maxRaius) {
                maxRaius = i;
            }
        }

        return maxRaius;
    }
}

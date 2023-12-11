package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/convert-1d-array-into-2d-array/></a>
 */
@Slf4j
public class No2022_将一维数组转变成二维数组 {

    @Test
    public void test1() {
        int[][] res = construct2DArray(new int[]{1, 2, 3, 4}, 2, 2);
        int[][] target = new int[][]{{1, 2}, {3, 4}};
        checkEqual(res, target);
    }

    @Test
    public void test2() {
        int[][] res = construct2DArray(new int[]{1, 2, 3}, 1, 3);
        int[][] target = new int[][]{{1, 2, 3}};
        checkEqual(res, target);
    }

    @Test
    public void test3() {
        int[][] res = construct2DArray(new int[]{1, 2}, 1, 1);
        int[][] target = new int[][]{};
        checkEqual(res, target);
    }

    @Test
    public void test4() {
        int[][] res = construct2DArray(new int[]{3}, 1, 2);
        int[][] target = new int[][]{};
        checkEqual(res, target);
    }

    @Test
    public void test5() {
        int[][] res = construct2DArray(new int[]{1, 1, 1, 1}, 4, 1);
        int[][] target = new int[][]{{1}, {1}, {1}, {1}};
        checkEqual(res, target);
    }

    private void checkEqual(int[][] res, int[][] target) {
        log.info("res={}", res);
        log.info("target={}", target);

        assert res.length == target.length;
        for (int i = 0; i < target.length; i++) {
            assert Arrays.equals(res[i], target[i]);
        }
    }

    /**
     * 分析：略
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }

        int[][] res = new int[m][n];
        int i = 0;
        int y = 0;
        for (; i < original.length; i++) {
            int x = i % n;
            res[y][x] = original[i];
            if (x == n - 1) {
                y++;
            }
        }
        return res;
    }
}

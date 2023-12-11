package label.array.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/reshape-the-matrix/"></a>
 */
@Slf4j
public class No566_重塑矩阵 {

    /**
     * 标签：数组
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int x = 0;
        int y = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[x][y] = mat[i][j];
                if (x < r) {
                    y++;
                    if (y >= c) {
                        y = 0;
                        x++;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test1() {
        int[][] res = matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
        System.out.println(res);
    }

    @Test
    public void test2() {
        int[][] res = matrixReshape(new int[][]{{1}}, 1, 1);
        System.out.println(res);
    }

    @Test
    public void test3() {
        int[][] res = matrixReshape(new int[][]{{1, 2}, {3, 4}}, 4, 1);
        System.out.println(res);
    }
}



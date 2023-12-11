package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/"></a>
 */
@Slf4j
public class No240_搜索二维矩阵_II {

    @Test
    public void test1() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        assert searchMatrix(matrix, 5);
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        assert !searchMatrix(matrix, 20);
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {1, 3, 5}
        };

        assert !searchMatrix(matrix, 4);
    }

    /**
     * 解：
     * 1 在第一行查找target可能在的最大列
     * 2 在第一列查找target可能在的最大行
     * 2 从符合条件的最后一行开始，从后到前遍历
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 如果第一个数 > target，则直接返回false
        if (matrix[0][0] > target) {
            return false;
        }
        // 如果最后一个数 < target，则直接返回false
        if (matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }

        int x = 0;
        int num;
        int xLength = matrix[0].length;
        while (x < xLength) {
            num = matrix[0][x];
            if (num == target) {
                return true;
            }
            if (num > target) {
                break;
            }
            x++;
        }

        int y = 0;
        int yLength = matrix.length;
        while (y < yLength) {
            num = matrix[y][0];
            if (num == target) {
                return true;
            }
            if (num > target) {
                break;
            }
            y++;
        }

        for (int i = x - 1; i >= 0; i--) {
            for (int j = y - 1; j >= 0; j--) {
                num = matrix[j][i];
                if (num == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

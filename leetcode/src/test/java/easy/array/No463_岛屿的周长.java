package easy.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/island-perimeter/"></a>
 */
@Slf4j
public class No463_岛屿的周长 {

    @Test
    public void test1() {
        assert 16 == islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
        assert 4 == islandPerimeter(new int[][]{{1}});
        assert 4 == islandPerimeter(new int[][]{{1, 0}});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：
     */
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // top
                    if (i == 0 || grid[i - 1][j] == 0) {
                        perimeter++;
                    }
                    // bottom
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        perimeter++;
                    }
                    // left
                    if (j == 0 || grid[i][j - 1] == 0) {
                        perimeter++;
                    }
                    // right
                    if (j == grid[i].length - 1 || grid[i][j + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }
}



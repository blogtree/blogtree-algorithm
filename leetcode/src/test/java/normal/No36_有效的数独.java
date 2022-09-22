package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode-cn.com/problems/valid-sudoku/"></a>
 */
@Slf4j
public class No36_有效的数独 {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 1 判断所有行中数符合条件
     * 2 判断所有列中数符合条件
     * 3 判断所有3x3中数符合条件
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 宽高长度
        int length = 9;
        // 临时变量
        Character rowNum, colNum;
        // 用于存储当前行、当前列、当前3x3的数字
        List<Character> rowList;
        List<Character> colList;
        Map<String, List<Character>> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(i + "-" + j, new LinkedList<>());
            }
        }
        // 遍历所有数字
        for (int i = 0; i < length; i++) {
            rowList = new LinkedList<>();
            colList = new LinkedList<>();
            for (int j = 0; j < length; j++) {
                rowNum = board[i][j];
                if (rowNum != '.') {
                    if (rowList.contains(rowNum)) {
                        return false;
                    } else {
                        rowList.add(rowNum);
                    }

                    // 计算3x3的方格位置
                    String location = (i / 3) + "-" + (j / 3);
                    List<Character> list = map.get(location);
                    if (list.contains(rowNum)) {
                        return false;
                    } else {
                        list.add(rowNum);
                    }
                }
                colNum = board[j][i];
                if (colNum != '.') {
                    if (colList.contains(colNum)) {
                        return false;
                    } else {
                        colList.add(colNum);
                    }
                }
            }
        }
        return true;
    }


}

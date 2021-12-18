import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/battleships-in-a-board/"></a>
 */
@Slf4j
public class No419_甲板上的战舰 {

    @Test
    public void test1() {
        char[][] board = new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        assert 2 == countBattleships(board);
    }

    @Test
    public void test2() {
        char[][] board = new char[][]{{'.'}};
        assert 0 == countBattleships(board);
    }

    @Test
    public void test3() {
    }

    /**
     * 战舰的标志，当前为 X
     */
    private char signBattleships = 'X';
    /**
     * 空位的标志，当前为 .
     */
    private char signEmpty = '.';

    /**
     * 发现一艘，移除一艘
     * 1 遍历二维数组，当发现存在战舰时，总数量+1
     * 2 继续查找上一步战舰位置的 右边 和 下边，如果为连续X，则设置为0。表示把这一个战舰清空
     */
    public int countBattleships(char[][] board) {
        int sum = 0;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == signBattleships) {
                    sum++;
                    clearRight(board, x, y);
                    clearDown(board, x, y);
                }
            }
        }
        return sum;
    }

    /**
     * 清理战舰右侧剩余位置
     */
    private void clearRight(char[][] board, int x, int y) {
        for (int i = y + 1; i < board[0].length; i++) {
            if (board[x][i] == signBattleships) {
                board[x][i] = signEmpty;
            } else {
                break;
            }
        }
    }

    /**
     * 清理战舰下侧剩余位置
     */
    private void clearDown(char[][] board, int x, int y) {
        for (int i = x + 1; i < board.length; i++) {
            if (board[i][y] == signBattleships) {
                board[i][y] = signEmpty;
            } else {
                break;
            }
        }
    }
}

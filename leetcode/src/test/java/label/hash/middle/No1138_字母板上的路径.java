package label.hash.middle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/alphabet-board-path/"></a>
 */
@Slf4j
public class No1138_字母板上的路径 {

    /**
     * 标签：哈希表 字符串
     */
    public String alphabetBoardPath(String target) {
        String[] board = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        Map<Character, Position> letterPositionMap = new HashMap<>();
        for (int x = 0; x < board.length; x++) {
            char[] charArray = board[x].toCharArray();
            for (int y = 0; y < charArray.length; y++) {
                char letter = charArray[y];
                letterPositionMap.put(letter, new Position(x, y));
            }
        }

        char[] targetLetterArray = target.toCharArray();
        Position from = new Position(0, 0);
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < targetLetterArray.length; i++) {
            char toLetter = targetLetterArray[i];
            Position to = letterPositionMap.get(toLetter);
            String tempPath = getPath(from, to, toLetter);
            path.append(tempPath);
            from = to;
        }

        return path.toString();
    }


    public class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public String getPath(Position from, Position to, char toLetter) {
        if (isEqual(from, to)) {
            return "!";
        }

        StringBuilder path = new StringBuilder();
        int moveX = Math.abs(from.x - to.x);
        if (toLetter == 'z') {
            moveX--;
        }
        for (int i = 0; i < moveX; i++) {
            if (from.x < to.x) {
                path.append("D");
            } else {
                path.append("U");
            }
        }
        for (int i = 0; i < Math.abs(from.y - to.y); i++) {
            if (from.y < to.y) {
                path.append("R");
            } else {
                path.append("L");
            }
        }
        if (toLetter == 'z') {
            path.append("D");
        }
        path.append("!");
        return path.toString();
    }


    public boolean isEqual(Position from, Position to) {
        return from.x == to.x && from.y == to.y;
    }


    @Test
    public void test1() {
        assert alphabetBoardPath("leet").equals("DDR!UURRR!!DDD!");
        assert alphabetBoardPath("code").equals("RR!DDRR!UUL!R!");
    }

    @Test
    public void test2() {
        assert alphabetBoardPath("zdz").equals("DDDDD!UUUUURRR!DDDDLLLD!");
    }

    @Test
    public void test3() {
    }


}

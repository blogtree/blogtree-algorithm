import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/length-of-last-word/"></a>
 */
@Slf4j
public class No58_最后一个单词的长度 {

    @Test
    public void test1() {
        assert 5 == lengthOfLastWord("Hello World");
        assert 4 == lengthOfLastWord("   fly me   to   the moon  ");
        assert 6 == lengthOfLastWord("luffy is still joyboy");
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            String item = arr[i];
            if (!" ".equals(item)) {
                return item.length();
            }
        }
        return 0;
    }
}

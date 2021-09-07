import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/"></a>
 */
@Slf4j
public class No1221_分割平衡字符串 {

    @Test
    public void test1() {
        assert 3 == balancedStringSplit("RLLLLRRRLR");
    }

    @Test
    public void test2() {
        assert 1 == balancedStringSplit("LLLLRRRR");
    }

    @Test
    public void test3() {
        assert 2 == balancedStringSplit("RLRRRLLRLL");
    }

    public int balancedStringSplit(String s) {
        int lCount = 0;
        int rCount = 0;
        int sum = 0;
        char[] chars = s.toCharArray();
        char item;
        for (int i = 0; i < chars.length; i++) {
            item = chars[i];
            if (item == 'L') {
                lCount++;
            } else if (item == 'R') {
                rCount++;
            }
            if (lCount == rCount && lCount > 0) {
                sum++;
                lCount = 0;
                rCount = 0;
            }
        }
        return sum;
    }

}

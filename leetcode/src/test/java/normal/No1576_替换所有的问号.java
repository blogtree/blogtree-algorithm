package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/"></a>
 */
@Slf4j
public class No1576_替换所有的问号 {

    @Test
    public void test1() {
        assert "azs".equals(modifyString("?zs"));
        assert "ubvaw".equals(modifyString("ubv?w"));
        assert "jaqgacb".equals(modifyString("j?qg??b"));
        assert "abywaipkja".equals(modifyString("??yw?ipkj?"));
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 步骤：
     * 1 字符串转字符数组，遍历字符数组
     * 2 找到'?'字符时，先获取它两端的字符，然后尝试用 a-z的字符替换
     * 3 替换字符 不能等于 两端字符
     * 4 全部替换完，则返回新的字符串
     */
    public String modifyString(String s) {
        char[] chars = s.toCharArray();

        char left;
        char right;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                left = (i > 0) ? chars[i - 1] : ' ';
                right = (i < chars.length - 1) ? chars[i + 1] : ' ';
                for (int j = 'a'; j <= 'z'; j++) {
                    if (j != left && j != right) {
                        chars[i] = (char) j;
                        break;
                    }
                }
            }
        }
        String res = new String(chars);
        return res;
    }
}

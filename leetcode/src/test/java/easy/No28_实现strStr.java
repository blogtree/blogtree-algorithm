package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/implement-strstr/"></a>
 */
@Slf4j
public class No28_实现strStr {

    @Test
    public void test1() {
        assert 2 == strStr("hello", "ll");
    }

    @Test
    public void test2() {
        assert -1 == strStr("aaaaa", "bba");
    }

    @Test
    public void test3() {
        assert 0 == strStr("", "");
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0 || haystack.length() < needle.length()) {
            return -1;
        }
        return haystack.indexOf(needle);
    }

}

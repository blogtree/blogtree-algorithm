package interview;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode-cn.com/problems/is-unique-lcci/"></a>
 */
@Slf4j
public class No01_01_判定字符是否唯一 {

    @Test
    public void test1() {
        assert !isUnique("leetcode");
    }

    @Test
    public void test2() {
        assert isUnique("abc");
    }

    @Test
    public void test3() {
    }

    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        return chars.length == set.size();
    }
}

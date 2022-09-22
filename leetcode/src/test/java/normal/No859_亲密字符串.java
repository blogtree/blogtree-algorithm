package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode-cn.com/problems/buddy-strings/"></a>
 */
@Slf4j
public class No859_亲密字符串 {

    @Test
    public void test1() {
        assert buddyStrings("ab", "ba");
        assert !buddyStrings("ab", "ab");
        assert buddyStrings("aa", "aa");
        assert buddyStrings("aaaaaaabc", "aaaaaaacb");
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 1. 先校验两个字符串的长度，不相同，则直接返回false
     * 2. 字符串转字符数组，遍历两个字符数组，获取不同的字符和位置
     * 3. 不同的字符超过两个，则直接返回false
     * 4. 不同的字符等于两个，是否判断交换后保持一致？
     * 5. 不同的字符串等于0个，则判断是否有重复的字符，用于交换。
     */
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.length() == 1) {
            return false;
        }
        List<Integer> diffChar = new LinkedList<>();
        Set<Character> charSet = new HashSet<>();
        char[] sChars = s.toCharArray();
        char[] goalChars = goal.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != goalChars[i]) {
                diffChar.add(i);
                if (diffChar.size() > 2) {
                    return false;
                }
            }
            charSet.add(sChars[i]);
        }

        if (diffChar.size() == 2) {
            return sChars[diffChar.get(0)] == goalChars[diffChar.get(1)] &&
                    sChars[diffChar.get(1)] == goalChars[diffChar.get(0)];
        } else if (diffChar.size() == 1) {
            return false;
        } else {
            return sChars.length > charSet.size();
        }
    }
}

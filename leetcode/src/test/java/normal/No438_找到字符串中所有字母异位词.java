package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/"></a>
 */
@Slf4j
public class No438_找到字符串中所有字母异位词 {

    @Test
    public void test1() {
        test("cbaebabacd", "abc");
    }

    @Test
    public void test2() {
        test("abab", "ab");
    }

    @Test
    public void test3() {
        test("aaaa", "a");
    }

    @Test
    public void test4() {
        test("aaaa", "aaaa");
    }

    private void test(String s, String p) {
        List res = findAnagrams(s, p);
        log.info("s={}, p={}, res={}", s, p, res);
    }

    /**
     * 1 p的长度大于s，则返回空
     * 2 获取p的字母集合
     * 3 遍历s的每个字符，判断当前字符是否在p的字母集合中，如果存在则判断p长度的字符是否都在p的字母集合中
     * 3-1 如果都在p的字母集合中，则判断是否为p的异位数
     * 3-2 如果发现某个字符不在p的字母集合中，则从下一个字符串开始，重新第3步。
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (p.length() > s.length()) {
            return res;
        }

        Set<Character> pCharSet = new HashSet<>();
        for (char c : p.toCharArray()) {
            pCharSet.add(c);
        }

        char[] sCharArr = s.toCharArray();
        char[] pCharArr = p.toCharArray();
        Arrays.sort(pCharArr);

        for (int i = 0; i < sCharArr.length - p.length() + 1; i++) {
            if (pCharSet.contains(sCharArr[i])) {
                // 判断 p.length() 长度的字符，是否都在 pCharSet 中
                boolean flag = true;
                for (int j = 1; j < p.length(); j++) {
                    if (!pCharSet.contains(sCharArr[i + j])) {
                        flag = false;
                        i = i + j;
                        break;
                    }
                }
                if (flag) {
                    if (isAnagrams(s.substring(i, i + p.length()).toCharArray(), pCharArr)) {
                        res.add(i);
                    }
                }
            }
        }
        return res;
    }

    private boolean isAnagrams(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }
        Arrays.sort(a);
        // Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}

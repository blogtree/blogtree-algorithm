package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode-cn.com/problems/keyboard-row/"></a>
 */
@Slf4j
public class No500_键盘行 {

    @Test
    public void test1() {
        String[] resArray = findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        log.info("resArray={}", Arrays.toString(resArray));
    }

    @Test
    public void test2() {
        String[] resArray = findWords(new String[]{"omk"});
        log.info("resArray={}", Arrays.toString(resArray));
    }

    @Test
    public void test3() {
        String[] resArray = findWords(new String[]{"adsdf", "sfd"});
        log.info("resArray={}", Arrays.toString(resArray));
    }

    @Test
    public void test4() {
        String[] resArray = findWords(new String[]{"Aasdfghjkl", "Qwertyuiop", "zZxcvbnm"});
        log.info("resArray={}", Arrays.toString(resArray));
    }


    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>(32);
        char[] chars1 = "qwertyuiop".toCharArray();
        for (char c : chars1) {
            map.put(c, 1);
        }
        char[] chars2 = "asdfghjkl".toCharArray();
        for (char c : chars2) {
            map.put(c, 2);
        }
        char[] chars3 = "zxcvbnm".toCharArray();
        for (char c : chars3) {
            map.put(c, 3);
        }

        List<String> res = new LinkedList<>();
        for (String word : words) {
            if (word.length() == 1) {
                res.add(word);
                continue;
            }
            char[] chars = word.toCharArray();
            char char1 = toLowerCase(chars[0]);
            int rowNum1 = map.get(char1);
            boolean sameRow = true;
            for (int i = 1; i < chars.length; i++) {
                int rowNum = map.get(toLowerCase(chars[i]));
                if (rowNum != rowNum1) {
                    sameRow = false;
                    break;
                }
            }
            if (sameRow) {
                res.add(word);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    /**
     * char类型小写
     */
    private char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            c += 32;
        }
        return c;
    }

}

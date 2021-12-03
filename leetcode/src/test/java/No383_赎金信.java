import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode-cn.com/problems/ransom-note/"></a>
 */
@Slf4j
public class No383_赎金信 {

    @Test
    public void test1() {
        assert !canConstruct("a", "b");
        assert !canConstruct("aa", "ab");
        assert !canConstruct("aa", "a");

        assert canConstruct("aa", "aab");
        assert canConstruct("abc", "defabcabc");
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 1 如果 ransomNote 长度大于 magazine，则返回false
     * 2 创建两个map，分别存储 ransomNote 和 magazine 的字母 和 字母的数量
     * 3 遍历 ransomNoteMap，对比 magazineMap中的字母数量
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> ransomNoteMap = arrayToMap(ransomNote.toCharArray());
        Map<Character, Integer> magazineMap = arrayToMap(magazine.toCharArray());

        for (Map.Entry<Character, Integer> entry : ransomNoteMap.entrySet()) {
            Integer magazineCount = magazineMap.get(entry.getKey());
            if (magazineCount == null || magazineCount < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> arrayToMap(char[] chars) {
        Map<Character, Integer> map = new HashMap<>(64);

        for (char c : chars) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        return map;
    }
}

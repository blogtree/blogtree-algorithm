import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/"></a>
 */
@Slf4j
public class No524_通过删除字母匹配到字典里最长单词 {

    @Test
    public void test1() {
        assert "apple".equals(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        assert "a".equals(findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
    }

    @Test
    public void test2() {
        assert "abc".equals(findLongestWord("abce", Arrays.asList("abe", "abc")));
    }

    @Test
    public void test3() {
        assert "ewaf".equals(findLongestWord("aewfafwafjlwajflwajflwafj",
                Arrays.asList("apple", "ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf")));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        TreeMap<Integer, List<String>> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        String str;
        for (int i = 0; i < dictionary.size(); i++) {
            str = dictionary.get(i);
            List<String> list = map.get(str.length());
            if (list == null) {
                list = new LinkedList<>();
                map.put(str.length(), list);
            }
            list.add(str);
        }

        // map中的list排序
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        char[] sourceChars = s.toCharArray();

        for (Map.Entry<Integer, List<String>> item : map.entrySet()) {
            for (int i = 0; i < item.getValue().size(); i++) {
                // 遍历当前字符数组
                String dicStr = item.getValue().get(i);
                char[] dicChars = dicStr.toCharArray();
                int noSource = 0, noDic = 0;
                while (noDic < dicChars.length && noSource < sourceChars.length) {
                    if (dicChars[noDic] == sourceChars[noSource]) {
                        noDic++;
                        noSource++;
                    } else {
                        noSource++;
                    }
                }
                if (noDic == dicChars.length) {
                    return dicStr;
                }
            }
        }
        return "";
    }
}

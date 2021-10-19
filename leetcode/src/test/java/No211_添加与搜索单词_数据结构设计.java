import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/"></a>
 */
@Slf4j
public class No211_添加与搜索单词_数据结构设计 {

    @Test
    public void test1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        assert !wordDictionary.search("pad"); // return False
        assert wordDictionary.search("bad"); // return True
        assert wordDictionary.search(".ad"); // return True
        assert wordDictionary.search("b.."); // return True
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    class WordDictionary {

        /**
         * 存储所有单词长度的列表
         */
        private List<Integer> wordLengthList = new LinkedList<>();

        /**
         * 存储所有单词的列表
         */
        private Map<Integer, List<Word>> dictMap = new HashMap<>();

        public WordDictionary() {

        }

        public void addWord(String word) {
            int length = word.length();

            // 存储长度
            if (!wordLengthList.contains(length)) {
                wordLengthList.add(length);
            }
            // 存储长度和单词
            List<Word> list = dictMap.get(length);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(new Word(word.length(), word.toCharArray()));
            if (list.size() == 1) {
                dictMap.put(length, list);
            }
        }

        public boolean search(String word) {
            int length = word.length();

            // 是否包含入参的单词长度
            if (!wordLengthList.contains(length)) {
                return false;
            }
            // 判断入参是否全部为 .
            if (word.replace(".", "").length() == 0) {
                return true;
            }

            List<Word> list = dictMap.get(length);
            for (Word item : list) {
                // 比较长度
                if (item.length == length) {
                    // 比较除 . 之外的字符串
                    // 默认相等
                    boolean flag = true;
                    char[] wordChars = word.toCharArray();
                    for (int i = 0; i < wordChars.length; i++) {
                        if (wordChars[i] != '.' && wordChars[i] != item.words[i]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        class Word {
            int length;
            char[] words;

            public Word(int length, char[] words) {
                this.length = length;
                this.words = words;
            }
        }
    }
}

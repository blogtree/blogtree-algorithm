import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

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

        private List<Word> dict = new LinkedList<>();

        public WordDictionary() {

        }

        public void addWord(String word) {
            dict.add(new Word(word.length(), word.toCharArray()));
        }

        public boolean search(String word) {
            for (Word item : dict) {
                // 比较长度
                if (item.length == word.length()) {
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

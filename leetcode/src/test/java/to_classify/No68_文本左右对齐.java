package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/text-justification/"></a>
 */
@Slf4j
public class No68_文本左右对齐 {

    @Test
    public void test1() {
        log.info("{}", fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }

    @Test
    public void test2() {
        log.info("{}", fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
    }

    @Test
    public void test3() {
        log.info("{}", fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to",
                "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int rowWidth = 0;
        List<String> rowStrList = new LinkedList<>();
        StringBuilder builder;
        List<String> resList = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int addStep = (rowWidth == 0) ? word.length() : 1 + word.length();
            if (rowWidth + addStep <= maxWidth) {
                rowStrList.add(word);
                rowWidth += addStep;
                if (i == words.length - 1) {
                    // 最后一行
                    builder = new StringBuilder();
                    for (int j = 0; j < rowStrList.size(); j++) {
                        builder.append(rowStrList.get(j));
                        if (j != rowStrList.size() - 1) {
                            builder.append(" ");
                        }
                    }
                    int addNum = maxWidth - builder.length();
                    for (int j = 0; j < addNum; j++) {
                        builder.append(" ");
                    }
                    resList.add(builder.toString());
                }
            } else {
                // 超出一行时，先计算剩余空格数量
                builder = new StringBuilder();
                if (rowStrList.size() == 1) {
                    builder.append(rowStrList.get(0));
                    for (int j = 0; j < maxWidth - rowStrList.get(0).length(); j++) {
                        builder.append(" ");
                    }
                } else {
                    int residue = maxWidth - rowWidth;
                    int numEvery = residue / (rowStrList.size() - 1);
                    int numFront = residue % (rowStrList.size() - 1);
                    for (int j = 0; j < rowStrList.size(); j++) {
                        builder.append(rowStrList.get(j));
                        if (j < rowStrList.size() - 1) {
                            builder.append(" ");
                        } else {
                            break;
                        }
                        for (int k = 0; k < numEvery; k++) {
                            builder.append(" ");
                        }
                        if (j < numFront) {
                            builder.append(" ");
                        }
                    }
                }
                resList.add(builder.toString());
                // clear
                rowStrList = new LinkedList<>();
                rowWidth = 0;
                i--;
            }
        }
        return resList;
    }
}

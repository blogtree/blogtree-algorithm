package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/occurrences-after-bigram/"></a>
 */
@Slf4j
public class No1078_Bigram_分词 {

    @Test
    public void test1() {
        String[] res = findOcurrences("alice is a good girl she is a good student", "a", "good");
        log.info("res={}", res);
        assert Arrays.equals(new String[]{"girl", "student"}, res);
    }

    @Test
    public void test2() {
        String[] res = findOcurrences("we will we will rock you", "we", "will");
        log.info("res={}", res);
        assert Arrays.equals(new String[]{"we", "rock"}, res);
    }

    @Test
    public void test3() {
        String[] res = findOcurrences("we will we will rock you", "we2", "will1");
        log.info("res={}", res);
        assert Arrays.equals(new String[]{}, res);
    }


    @Test
    public void test4() {
        String[] res = findOcurrences("we will we will rock you", "rock", "you");
        log.info("res={}", res);
        assert Arrays.equals(new String[]{}, res);
    }

    @Test
    public void test5() {
        String[] res = findOcurrences("we will we will rock you", "will", "rock");
        log.info("res={}", res);
        assert Arrays.equals(new String[]{"you"}, res);
    }

    /**
     * 步骤：
     * 1 按空格拆分为字符串数组
     * 2 遍历数组，匹配 first、second
     * 3 注意边界校验
     */
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        if (words.length < 3) {
            return new String[]{};
        }

        List<String> res = new LinkedList<>();

        for (int i = 0; i < words.length - 2; i++) {
            if (first.equals(words[i])) {
                if (second.equals(words[i + 1])) {
                    res.add(words[i + 2]);
                }
            }
        }

        String[] str = new String[res.size()];
        return res.toArray(str);
    }
}

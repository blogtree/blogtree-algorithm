package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;

/**
 * @see <a href="https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/"></a>
 */
@Slf4j
public class No423_从英文中重建数字 {

    @Test
    public void test1() {
        assert "012".equals(originalDigits("owoztneoer"));
        assert "45".equals(originalDigits("fviefuro"));
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }


    /**
     * 1 <= s.length <= 105
     * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
     * s 保证是一个符合题目要求的字符串
     * <p>
     * <p>
     * 数字 英文 唯一的字母
     * 0 zero   z
     * 1 one    o（去掉 zero、two、four）
     * 2 two    w
     * 3 three  h（去掉 eight）
     * 4 four   r（去掉 zero、three）
     * 5 five   f（去掉 four）
     * 6 six    i（去掉 five、eight）
     * 7 seven  s（去掉 six）
     * 8 eight  g
     * 9 nine   i（去掉 five、six、eight）
     * <p>
     * 剔除顺序：zero、two、six、eight、three、four、five、one、seven、nine
     */
    public String originalDigits(String s) {
        if (s.length() < 3) {
            return "";
        }
        char[] chars = s.toCharArray();
        int zero = getCharCount(chars, 'z');
        int two = getCharCount(chars, 'w');
        int six = getCharCount(chars, 'x');
        int eight = getCharCount(chars, 'g');
        int three = getCharCount(chars, 'h') - eight;
        int four = getCharCount(chars, 'r') - zero - three;
        int five = getCharCount(chars, 'f') - four;
        int one = getCharCount(chars, 'o') - zero - two - four;
        int seven = getCharCount(chars, 's') - six;
        int nine = getCharCount(chars, 'i') - five - six - eight;

        StringBuilder builder = new StringBuilder();
        builder.append(String.join("", Collections.nCopies(zero, "0")));
        builder.append(String.join("", Collections.nCopies(one, "1")));
        builder.append(String.join("", Collections.nCopies(two, "2")));
        builder.append(String.join("", Collections.nCopies(three, "3")));
        builder.append(String.join("", Collections.nCopies(four, "4")));
        builder.append(String.join("", Collections.nCopies(five, "5")));
        builder.append(String.join("", Collections.nCopies(six, "6")));
        builder.append(String.join("", Collections.nCopies(seven, "7")));
        builder.append(String.join("", Collections.nCopies(eight, "8")));
        builder.append(String.join("", Collections.nCopies(nine, "9")));
        return builder.toString();
    }

    /**
     * 获取某个字符在字符串中的数量
     */
    public int getCharCount(char[] chars, char c) {
        if (chars.length == 0) {
            return 0;
        }
        int count = 0;
        for (char item : chars) {
            if (item == c) {
                count++;
            }
        }
        return count;
    }
}

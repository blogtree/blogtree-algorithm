package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/add-binary/"></a>
 */
@Slf4j
public class No67_二进制求和 {

    @Test
    public void test1() {
        assert "100".equals(addBinary("11", "1"));
    }

    @Test
    public void test2() {
        assert "10101".equals(addBinary("1010", "1011"));
    }

    @Test
    public void test3() {
        assert "11110".equals(addBinary("1111", "1111"));
    }

    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        char[] sumChars = new char[Math.max(a.length(), b.length())];

        int aIndex = aChars.length - 1;
        int bIndex = bChars.length - 1;
        int sumIndex = sumChars.length - 1;
        int addOne = 0;
        while (aIndex > -1 || bIndex > -1) {
            int aNum = (aIndex > -1) ? charToInt(aChars[aIndex]) : 0;
            int bNum = (bIndex > -1) ? charToInt(bChars[bIndex]) : 0;
            int sumNum = aNum + bNum + addOne;
            if (sumNum > 1) {
                addOne = 1;
                sumChars[sumIndex] = intToChar(sumNum - 2);
            } else {
                addOne = 0;
                sumChars[sumIndex] = intToChar(sumNum);
            }
            aIndex--;
            bIndex--;
            sumIndex--;
        }
        String res = String.valueOf(sumChars);
        if (addOne == 1) {
            res = "1" + res;
        }
        return res;
    }

    private int charToInt(char val) {
        return Integer.valueOf(String.valueOf(val));
    }

    private char intToChar(int num) {
        switch (num) {
            case 0:
                return '0';
            case 1:
                return '1';
            case 2:
                return '2';
            default:
                return ' ';
        }
    }
}

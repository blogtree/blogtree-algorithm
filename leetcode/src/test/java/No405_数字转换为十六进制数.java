import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/"></a>
 */
@Slf4j
public class No405_数字转换为十六进制数 {

    @Test
    public void test1() {
        assert "1".equals(toHex(1));
    }

    @Test
    public void test2() {
        assert "10".equals(toHex(16));
    }

    @Test
    public void test3() {
        assert "1a".equals(toHex(26));
    }

    @Test
    public void test4() {
        assert "ffffffff".equals(toHex(-1));
    }

    @Test
    public void test5() {
        assert "fffffffe".equals(toHex(-2));
    }

    @Test
    public void test6() {
        assert "80000000".equals(toHex(-2147483648));
    }


    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        List<String> hexList = new LinkedList<>();
        long temp = num > 0 ? num : (4294967295L - (num * -1) + 1);
        while (temp > 0) {
            long surplus = temp % 16;
            hexList.add(0, toHexSingleNum((int) surplus));
            temp = (temp - surplus) / 16;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < hexList.size(); i++) {
            builder.append(hexList.get(i));
        }
        String hex = builder.toString();
        return hex.length() > 8 ? hex.substring(hex.length() - 8) : hex;
    }

    private String toHexSingleNum(int num) {
        if (num < 10) {
            return String.valueOf(num);
        } else {
            switch (num) {
                case 10:
                    return "a";
                case 11:
                    return "b";
                case 12:
                    return "c";
                case 13:
                    return "d";
                case 14:
                    return "e";
                case 15:
                    return "f";
                default:
                    return "";
            }
        }
    }
}

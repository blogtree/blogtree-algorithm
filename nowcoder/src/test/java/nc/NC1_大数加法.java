package nc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475"></a>
 */
@Slf4j
public class NC1_大数加法 {

    @Test
    public void test1() {
        assert "0".equals(solve("", ""));
        assert "0".equals(solve("0", "0"));
        assert "1".equals(solve("1", "0"));
        assert "1".equals(solve("0", "1"));
        assert "2".equals(solve("1", "1"));
        assert "10".equals(solve("1", "9"));
        assert "11".equals(solve("2", "9"));
    }

    @Test
    public void test2() {
        assert "100".equals(solve("1", "99"));
        assert "114514".equals(solve("114514", ""));
    }

    @Test
    public void test3() {
    }


    /**
     * 分析：
     * 1 将两个字符串 转为 字符数组
     * 2 从最后遍历字符数组（即从个位数开始），相应位置的数值进行相加，并存储是否需要进位
     * 3 被进位的数值，需要+1
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // 边界值处理
        if (isZero(s)) {
            if (isZero(t)) {
                return "0";
            }
            return t;
        }
        if (isZero(t)) {
            return s;
        }
        // 声明两个字符数组
        char[] charsLong;
        char[] charsShort;
        if (s.length() > t.length()) {
            charsLong = s.toCharArray();
            charsShort = t.toCharArray();
        } else {
            charsLong = t.toCharArray();
            charsShort = s.toCharArray();
        }
        // 当前位是否需要+1
        int addNum = 0;
        int sum;

        // 遍历两个字符数组
        for (int i = charsLong.length - 1, j = charsShort.length - 1; i >= 0; i--, j--) {
            if (j >= 0) {
                sum = charsLong[i] - '0' + charsShort[j] - '0';
            } else {
                sum = charsLong[i] - '0';
            }
            // 加上进位
            sum += addNum;
            // 判断是否超过了9
            if (sum > 9) {
                charsLong[i] = Character.forDigit(sum - 10, 10);
                addNum = 1;
            } else {
                charsLong[i] = Character.forDigit(sum, 10);
                addNum = 0;
            }
        }

        return addNum == 1 ? "1" + String.valueOf(charsLong) : String.valueOf(charsLong);
    }

    /**
     * 判断是否为0（仅适用于本题）
     */
    private boolean isZero(String str) {
        return str.length() == 0 || "0".equals(str);
    }
}

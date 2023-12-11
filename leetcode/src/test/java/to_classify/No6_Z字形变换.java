package to_classify;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/zigzag-conversion/"></a>
 * <p>
 * 题目：将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */
public class No6_Z字形变换 {

    @Test
    public void test() {
        assert "PAHNAPLSIIGYIR".equals(convert("PAYPALISHIRING", 3));
        assert "PINALSIGYAHRPI".equals(convert("PAYPALISHIRING", 4));
        assert "A".equals(convert("A", 1));
    }

    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }
        List<StringBuffer> list = new LinkedList();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }
        char[] chars = s.toCharArray();
        int numCols = (numRows + numRows - 2);
        for (int i = 0; i < chars.length; i++) {
            int row = i % numCols;
            if (row >= numRows) {
                row = numCols - row;
            }
            StringBuffer buffer = list.get(row);
            buffer.append(chars[i]);
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer buffer : list) {
            res.append(buffer.toString());
        }
        return res.toString();
    }
}

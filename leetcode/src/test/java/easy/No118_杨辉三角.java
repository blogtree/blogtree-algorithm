package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle/"></a>
 */
@Slf4j
public class No118_杨辉三角 {

    @Test
    public void test1() {
        List res = generate(5);
        print(res);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    private void print(List res) {
        for (int i = 0; i < res.size(); i++) {
            log.info("rowNo={}, row={}", i + 1, res.get(i));
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new LinkedList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    // 首尾为1
                    row.add(1);
                } else {
                    // 中间部位为上一行的两个数值相加
                    List<Integer> upRow = res.get(i - 2);
                    row.add(upRow.get(j - 2) + upRow.get(j - 1));
                }
            }
            res.add(row);
        }

        return res;
    }
}

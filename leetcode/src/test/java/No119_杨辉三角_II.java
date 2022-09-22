import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle-ii/"></a>
 */
@Slf4j
public class No119_杨辉三角_II {

    @Test
    public void test1() {
        for (int i = 0; i <= 33; i++) {
            print(getRow(i));
        }
    }

    @Test
    public void test2() {
        print(getRow(3));
    }

    @Test
    public void test3() {
    }

    private void print(List res) {
        log.info("rowNo={}, row={}", res.size() - 1, res);
    }

    /**
     * 用一个数组和一个变量 存储需要相加的值，然后遍历rowIndex+1次
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            res.add(1);
        }
        if (rowIndex < 2) {
            return res;
        }

        for (int i = 2; i <= rowIndex; i++) {
            int upLeftVal = 1;
            for (int j = 1; j < i; j++) {
                int newVal = upLeftVal + res.get(j);
                upLeftVal = res.get(j);
                res.set(j, newVal);
            }
        }
        return res;
    }
}

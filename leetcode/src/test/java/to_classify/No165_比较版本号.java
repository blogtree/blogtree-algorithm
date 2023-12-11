package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/compare-version-numbers/"></a>
 */
@Slf4j
public class No165_比较版本号 {

    @Test
    public void test1() {
        assert 0 == compareVersion("1.01", "1.001");
        assert 0 == compareVersion("1.0", "1.0.0");
        assert -1 == compareVersion("0.1", "1.1");
    }

    @Test
    public void test2() {
        assert 1 == compareVersion("1.0.1", "1");
    }

    @Test
    public void test3() {
        assert -1 == compareVersion("7.5.2.4", "7.5.3");
    }


    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int index1 = 0, index2 = 0;
        while (index1 < arr1.length || index2 < arr2.length) {
            int num1 = (index1 < arr1.length) ? Integer.valueOf(arr1[index1]) : 0;
            int num2 = (index2 < arr2.length) ? Integer.valueOf(arr2[index2]) : 0;
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            } else {
                index1++;
                index2++;
            }
        }
        return 0;
    }
}

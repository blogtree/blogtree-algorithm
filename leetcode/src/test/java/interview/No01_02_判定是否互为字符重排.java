package interview;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/check-permutation-lcci/"></a>
 */
@Slf4j
public class No01_02_判定是否互为字符重排 {

    @Test
    public void test1() {
        assert checkPermutation("abc", "bca");
    }

    @Test
    public void test2() {
        assert !checkPermutation("abc", "bad");
    }

    @Test
    public void test3() {
    }

    public boolean checkPermutation(String s1, String s2) {
        // 长度需要一致
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        // 排序
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        // 对比
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }
}

package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/assign-cookies/"></a>
 */
@Slf4j
public class No455_分发饼干 {

    @Test
    public void test1() {
        assert findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}) == 1;
        assert findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}) == 2;
        assert findContentChildren(new int[]{1, 2, 3}, new int[]{1, 2, 2}) == 2;
        assert findContentChildren(new int[]{1, 2, 3}, new int[]{1, 2, 3}) == 3;
        assert findContentChildren(new int[]{1, 2, 3}, new int[]{}) == 0;
    }

    @Test
    public void test2() {
        assert findContentChildren(new int[]{10, 9, 8, 7, 10, 9, 8, 7}, new int[]{10, 9, 8, 7}) == 4;
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：贪心 数组 双指针 排序
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentCount = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            while (j < s.length) {
                if (s[j] >= g[i]) {
                    contentCount++;
                    j++;
                    break;
                }
                j++;
            }
            if (j == s.length) {
                break;
            }
        }
        return contentCount;
    }
}



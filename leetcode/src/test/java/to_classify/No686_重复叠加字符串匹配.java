package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/repeated-string-match/"></a>
 */
@Slf4j
public class No686_重复叠加字符串匹配 {

    @Test
    public void test1() {
        assert 3 == repeatedStringMatch("abcd", "cdabcdab");
        assert 2 == repeatedStringMatch("a", "aa");
        assert 1 == repeatedStringMatch("a", "a");
        assert -1 == repeatedStringMatch("abc", "wxxyz");
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：如果b成为a的子集，则a的长度应该 >= b 或 2b
     * 步骤：
     * 1 先将字符串a叠加到总长度大于等于b
     * 2 判断b是否为a的子集
     * 3 如果不是，则在累加一次a
     * 4 再判断b是否为a的子集
     */
    public int repeatedStringMatch(String a, String b) {
        int repeatedCount = 1;
        StringBuilder aBuilder = new StringBuilder(a);

        while (aBuilder.length() < b.length()) {
            aBuilder.append(a);
            repeatedCount++;
        }

        if (aBuilder.toString().contains(b)) {
            return repeatedCount;
        }

        aBuilder.append(a);
        repeatedCount++;
        if (aBuilder.toString().contains(b)) {
            return repeatedCount;
        }

        return -1;
    }
}

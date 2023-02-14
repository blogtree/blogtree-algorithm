package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/description/"></a>
 */
@Slf4j
public class No1700_无法吃午餐的学生数量 {

    @Test
    public void test1() {
        assert 3 == countStudents(new int[]{1, 1, 1, 0}, new int[]{0, 0, 0, 1});
        assert 0 == countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：
     * 分析：
     * 1
     * 2
     * 3
     */
    public int countStudents(int[] students, int[] sandwiches) {
        int[] likeCount = new int[]{0, 0};
        for (int i = 0; i < students.length; i++) {
            likeCount[students[i]]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (likeCount[sandwiches[i]] == 0) {
                return likeCount[1 - sandwiches[i]];
            }
            likeCount[sandwiches[i]]--;
        }
        return 0;
    }
}

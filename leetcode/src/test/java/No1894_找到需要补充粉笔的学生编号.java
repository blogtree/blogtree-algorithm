import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/"></a>
 */
@Slf4j
public class No1894_找到需要补充粉笔的学生编号 {

    @Test
    public void test1() {
        assert 0 == chalkReplacer(new int[]{5, 1, 5}, 22);
        assert 1 == chalkReplacer(new int[]{3, 4, 1, 2}, 25);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int chalkReplacer(int[] chalk, int k) {
        // 所有学生需要消耗的粉笔数
        int sumNeed = 0;
        // 遍历一遍学生
        for (int i = 0; i < chalk.length; i++) {
            int need = chalk[i];
            if (k >= need) {
                k -= need;
            } else {
                return i;
            }
            sumNeed += need;
        }

        // 如果遍历一遍还有剩余，则先取余数
        k = k % sumNeed;
        // 再遍历一遍学生
        for (int i = 0; i < chalk.length; i++) {
            int need = chalk[i];
            if (k >= need) {
                k -= need;
            } else {
                return i;
            }
        }
        return 0;
    }
}

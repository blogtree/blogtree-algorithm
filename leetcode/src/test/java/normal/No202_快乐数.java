package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode-cn.com/problems/happy-number/"></a>
 */
@Slf4j
public class No202_快乐数 {

    @Test
    public void test1() {
        assert isHappy(1);
        assert !isHappy(Integer.MAX_VALUE);
    }

    @Test
    public void test2() {
        assert !isHappy(2);
        assert isHappy(19);
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：
     * 1 定义一个set，用来存储n
     * 2 while循环计算 当前值 每个位置上的数字平方和，并存储到set中
     * 2-1 当计算结果 == 1时，跳出循环，n为快乐数
     * 2-2 当计算结果 在set中出现过，表示存在无限循环，n不是快乐数
     *
     * 其他解法：快慢指针法
     */
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Long> set = new HashSet<>();
        long temp = n;
        while (true) {
            temp = calculate(temp);
            if (temp == 1) {
                return true;
            }
            if (set.contains(temp)) {
                return false;
            }
            set.add(temp);
        }
    }

    private long calculate(long n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        long sum = 0;
        for (int i = 0; i < chars.length; i++) {
            long num = Character.digit(chars[i], 10);
            sum += num * num;
        }
        return sum;
    }
}

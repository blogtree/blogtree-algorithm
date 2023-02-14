package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/day-of-the-year/"></a>
 */
@Slf4j
public class No1154_一年中的第几天 {

    @Test
    public void test1() {
        assert 9 == dayOfYear("2019-01-09");
        assert 41 == dayOfYear("2019-02-10");
        assert 60 == dayOfYear("2003-03-01");
        assert 61 == dayOfYear("2004-03-01");
        assert 61 == dayOfYear("2000-03-01");
        assert 339 == dayOfYear("2000-12-04");
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 拥有31天的月份
     */
    private List<Integer> monthListWith31Days = Arrays.asList(1, 3, 5, 7, 8, 10, 12);

    /**
     * 分析：略，注意二月份是28天，还是29天
     * 步骤：
     * 1 截取字符串中的 年月日，转化成数字
     * 2 当前月的天数，直接加上
     * 3 累加之前月份的天数（第二个月除外）
     * 4 累加第二个月的总天数
     */
    public int dayOfYear(String date) {
        String[] parts = date.split("-");
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // 当前月的天数，直接加上
        int dayOfYear = day;

        // 累加之前月份的天数（第二个月除外）
        for (int i = 1; i < month; i++) {
            if (monthListWith31Days.contains(i)) {
                dayOfYear += 31;
            } else if (i != 2) {
                dayOfYear += 30;
            }
        }

        // 累加第二个月的总天数
        if (month > 2) {
            int year = Integer.parseInt(parts[0]);
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                dayOfYear += 29;
            } else {
                dayOfYear += 28;
            }
        }

        return dayOfYear;
    }
}

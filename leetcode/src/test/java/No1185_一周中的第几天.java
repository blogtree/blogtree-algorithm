import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/day-of-the-week/"></a>
 */
@Slf4j
public class No1185_一周中的第几天 {

    @Test
    public void test1() {
        assert "Friday".equals(dayOfTheWeek(1, 1, 1971));
    }

    @Test
    public void test2() {
        assert "Saturday".equals(dayOfTheWeek(31, 8, 2019));
        assert "Sunday".equals(dayOfTheWeek(18, 7, 1999));
        assert "Sunday".equals(dayOfTheWeek(15, 8, 1993));
    }

    @Test
    public void test3() {
        String resByLeetcode = dayOfTheWeekByLeetcode(29, 2, 2016);
        String res = dayOfTheWeek(29, 2, 2016);
        assert "Sunday".equals(dayOfTheWeekByLeetcode(29, 2, 2016));
        assert "Sunday".equals(dayOfTheWeek(29, 2, 2016));
    }

    /**
     * 每个月的天数（二月份为0，需要单独计算）
     */
    private int[] dayOfMonth = new int[]{31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * 星期一 到 星期日 的英文名数组
     */
    private String[] dayOfWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    /**
     * 当年是否为闰年
     */
    private boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0
                || year % 400 == 0;
    }

    /**
     * 方法一：
     * 1 1970年1月1日是星期四
     * 2 计算入参时间 与 它相差的相差天数
     * 3 相差天数 与 7 取余
     * <p>
     * 方法二：
     * 直接调用 LocalDate 的  getDayOfWeek() 方法
     */
    public String dayOfTheWeek(int day, int month, int year) {
        // 方法一：
        int sumDay = 0;
        // 加之前年份的天数
        for (int i = 1970; i < year; i++) {
            if (isLeapYear(i)) {
                sumDay += 366;
            } else {
                sumDay += 365;
            }
        }

        // 加当年 之前月份的天数
        for (int i = 1; i < month; i++) {
            sumDay += dayOfMonth[i - 1];
        }

        // 加二月份的天数
        if (month > 2) {
            sumDay += isLeapYear(year) ? 29 : 28;
        }
        // 加当月的天数
        sumDay += day;

        // 总天数和7取余数
        int mod = (sumDay + 2) % 7;
        return dayOfWeek[mod];

        // 方法二：
//        LocalDate localDate = LocalDate.of(year, month, day);
//        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
//        String dayOfTheWeek = dayOfWeek.name().toLowerCase(Locale.ROOT);
//        dayOfTheWeek = dayOfTheWeek.substring(0, 1).toUpperCase(Locale.ROOT) + dayOfTheWeek.substring(1);
//        return dayOfTheWeek;
    }

    public String dayOfTheWeekByLeetcode(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        /* 输入年份之前的年份的天数贡献 */
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        /* 输入年份中，输入月份之前的月份的天数贡献 */
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        /* 输入月份中的天数贡献 */
        days += day;
        return week[(days + 3) % 7];
    }
}

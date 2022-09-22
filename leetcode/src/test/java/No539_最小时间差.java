import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/minimum-time-difference/"></a>
 * <p>
 * 数组 数学 字符串 排序
 */
@Slf4j
public class No539_最小时间差 {

    @Test
    public void test1() {
        assert 1 == findMinDifference(Arrays.asList("23:59", "00:00"));
        assert 0 == findMinDifference(Arrays.asList("00:00", "23:59", "00:00"));
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：
     * 1 先将时间列表转为分钟，再排序
     * 2 遍历排序好的时间列表，依次计算两个时间的差值，存储最小的时间差
     * 3 最后计算列表中 首尾两个时间的差值，与最小时间差对比
     */
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) {
            // 根据题意，一共有24 × 60 = 1440 种不同的时间。
            // 由鸽巢原理可知，如果 timePoints 的长度超过 1440，那么必然会有两个相同的时间，此时可以直接返回 0。
            return 0;
        }

        List<Integer> minuteList = new ArrayList<>(timePoints.size() + 1);

        for (String timePoint : timePoints) {
            minuteList.add(timePointToMinute(timePoint));
        }

        // 排序
        Collections.sort(minuteList);

        // 将第一个元素添加 24 * 60 分钟后，添加到列表末尾
        minuteList.add(minuteList.get(0) + 24 * 60);

        int minDiff = 24 * 60;
        for (int i = 0; i < minuteList.size() - 1; i++) {
            int diff = minuteList.get(i + 1) - minuteList.get(i);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    private int timePointToMinute(String timePoint) {
        String[] parts = timePoint.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

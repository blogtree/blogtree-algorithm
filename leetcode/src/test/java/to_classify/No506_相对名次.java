package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode-cn.com/problems/relative-ranks/"></a>
 */
@Slf4j
public class No506_相对名次 {

    @Test
    public void test1() {
        assert Arrays.equals(findRelativeRanks(new int[]{5, 4, 3, 2, 1}),
                new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"});
        assert Arrays.equals(findRelativeRanks(new int[]{5}),
                new String[]{"Gold Medal"});
    }

    @Test
    public void test2() {
        assert Arrays.equals(findRelativeRanks(new int[]{10, 3, 8, 9, 4}),
                new String[]{"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"});
    }

    @Test
    public void test3() {
    }

    /**
     * 1 复制一份score，并排序
     * 2 遍历有序的score，创建一个map，用于存储分数对应的名次
     * 3 遍历score，从map中获取名次，创建返回值
     */
    public String[] findRelativeRanks(int[] score) {
        if (score.length == 1) {
            return new String[]{"Gold Medal"};
        }

        int[] scoreOrdered = score.clone();
        Arrays.sort(scoreOrdered);

        Map<Integer, String> map = new HashMap<>(score.length);
        for (int i = 0; i < scoreOrdered.length; i++) {
            map.put(scoreOrdered[i], String.valueOf(scoreOrdered.length - i));
        }

        String[] orders = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            String order = map.get(score[i]);
            if ("1".equals(order)) {
                orders[i] = "Gold Medal";
            } else if ("2".equals(order)) {
                orders[i] = "Silver Medal";
            } else if ("3".equals(order)) {
                orders[i] = "Bronze Medal";
            } else {
                orders[i] = order;
            }
        }

        return orders;
    }
}

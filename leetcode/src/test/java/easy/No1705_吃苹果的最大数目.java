package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/"></a>
 */
@Slf4j
public class No1705_吃苹果的最大数目 {

    @Test
    public void test1() {
        assert 7 == eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2});
    }

    @Test
    public void test2() {
        assert 5 == eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2});
    }

    @Test
    public void test3() {
        assert 0 == eatenApples(new int[]{0}, new int[]{0});
    }

    @Test
    public void test4() {
        assert 4 == eatenApples(new int[]{2, 1, 10}, new int[]{2, 10, 1});
    }

    @Test
    public void test5() {
        assert 5 == eatenApples(new int[]{9, 2}, new int[]{3, 5});
    }


    /**
     * 分析：
     * 0 优先吃快过期的苹果
     * 1 利用优先队列，存 [过期时间 , 苹果数量] 的二维数组
     * 2 先遍历 apples，一边存苹果，一边吃苹果
     * 3 遍历 apples 后，按照顺序吃苹果
     */
    public int eatenApples(int[] apples, int[] days) {
        int sumEatDay = 0;

        Comparator<int[]> cmp = (e1, e2) -> e1[0] - e2[0];
        PriorityQueue<int[]> queue = new PriorityQueue<>(cmp);

        int day = 0;
        for (; day < apples.length; day++) {
            int apple = apples[day];
            if (apple > 0) {
                int overtime = day + days[day] - 1;
                // 存到queue中
                queue.add(new int[]{overtime, apple});
            }

            // 如果没有可以取的队列，则跳出本次循环
            if (queue.size() == 0) {
                continue;
            }

            // 获取一个快过期的苹果
            boolean eat = false;
            while (!eat && queue.size() > 0) {
                // 获取第一个
                int[] item = queue.peek();
                // 如果苹果数量为0，则移除
                if (item[1] == 0) {
                    queue.poll();
                    continue;
                }
                // 如果已经过期，则移除
                if (item[0] < day) {
                    queue.poll();
                    continue;
                }
                item[1]--;
                sumEatDay++;
                eat = true;
            }
        }

        while (queue.size() > 0) {
            // 获取第一个
            int[] item = queue.peek();
            // 如果苹果数量为0，则移除
            if (item[1] == 0) {
                queue.poll();
                continue;
            }
            // 如果已经过期，则移除
            if (item[0] < day) {
                queue.poll();
                continue;
            }
            item[1]--;
            sumEatDay++;
            day++;
        }

        return sumEatDay;
    }


}

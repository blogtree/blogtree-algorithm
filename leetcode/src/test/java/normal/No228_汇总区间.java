package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/summary-ranges/"></a>
 */
@Slf4j
public class No228_汇总区间 {

    @Test
    public void test1() {
        log.info("{}", summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        log.info("{}", summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：遇到连续的数字，则需要改为区间
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        if (nums.length == 0) {
            return list;
        }

        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == nums[i - 1] + 1) {
                // 等于前一个数+1
                continue;
            } else {
                appendList(start, i, nums, list);

                // 设置当前值为开始
                nums[start] = num;
                start = i;
            }
        }
        // 末尾追加
        appendList(start, nums.length, nums, list);

        return list;
    }

    private void appendList(int start, int end, int[] nums, List<String> list) {
        if (end - start == 1) {
            // 相邻
            list.add(nums[start] + "");
        } else {
            // 不相邻
            list.add(nums[start] + "->" + nums[end - 1]);
        }
    }

}

package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode-cn.com/problems/majority-element-ii/"></a>
 */
@Slf4j
public class No229_求众数_II {

    @Test
    public void test1() {
        assert Arrays.asList(3).equals(majorityElement(new int[]{3, 2, 3}));
    }

    @Test
    public void test2() {
        assert Arrays.asList(1).equals(majorityElement(new int[]{1}));
    }

    @Test
    public void test3() {
        assert Arrays.asList(1, 2).equals(majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }

    @Test
    public void test4() {
        assert Arrays.asList(2).equals(majorityElement(new int[]{2, 2}));
    }

    @Test
    public void test5() {
        assert Arrays.asList(1, 2).equals(majorityElement(new int[]{1, 2}));
    }

    @Test
    public void test6() {
        assert Arrays.asList(4).equals(majorityElement(new int[]{4, 1, 3, 1, 3, 3, 1, 2, 3, 2, 4, 2, 1, 4, 4, 4, 4, 4}));
    }


    /**
     * 思路：
     * 1 先对数组排序
     * 2 再遍历排序好的数组
     * 3 定义一个计数变量，如果前后数字相同，则+1；不同，则判断是否符合条件，再清零
     */
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length < 2) {
            return Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toList());
        }
        // 先排序
        Arrays.sort(nums);
        // 定义计数变量
        int count = 1;
        int minCount = nums.length / 3;
        List<Integer> resList = new LinkedList<>();
        // 再遍历
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > minCount) {
                resList.add(nums[i - 1]);
                while (i < nums.length && nums[i] == nums[i - 1]) {
                    i++;
                }
                count = 1;
            }
        }
        // 末尾处理
        if (minCount == 0 && nums[nums.length - 1] != nums[nums.length - 2]) {
            resList.add(nums[nums.length - 1]);
        }

        return resList;
    }
}

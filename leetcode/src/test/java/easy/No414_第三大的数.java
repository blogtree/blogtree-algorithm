package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/third-maximum-number/"></a>
 */
@Slf4j
public class No414_第三大的数 {

    @Test
    public void test1() {
        assert 1 == thirdMax(new int[]{3, 2, 1});
        assert 2 == thirdMax(new int[]{1, 2});
        assert 1 == thirdMax(new int[]{2, 2, 3, 1});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }


    public int thirdMax(int[] nums) {
        int maxCount = 3;
        List<Integer> maxList = new LinkedList();
        for (int i = 0; i < maxCount; i++) {
            maxList.add(null);
        }

        // 遍历入参数组
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            boolean needRemoveLastOne = false;
            // 遍历最大的数的数组
            for (int j = 0; j < maxCount; j++) {
                Integer max = maxList.get(j);
                if (max == null) {
                    // 将num插入到这里
                    maxList.add(j, num);
                    break;
                }
                if (max.equals(num)) {
                    break;
                } else if (max < num) {
                    // 将num插入到这里
                    maxList.add(j, num);
                    needRemoveLastOne = true;
                    break;
                }
            }
            if (needRemoveLastOne) {
                maxList.remove(maxCount);
            }
        }
        if (maxList.get(maxCount - 1) == null) {
            return maxList.get(0);
        } else {
            return maxList.get(maxCount - 1);
        }
    }
}

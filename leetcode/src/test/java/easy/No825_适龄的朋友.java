package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/friends-of-appropriate-ages/"></a>
 */
@Slf4j
public class No825_适龄的朋友 {

    @Test
    public void test1() {
        assert 2 == numFriendRequests(new int[]{16, 16});
    }

    @Test
    public void test2() {
        assert 2 == numFriendRequests(new int[]{16, 17, 18});
    }

    @Test
    public void test3() {
        assert 3 == numFriendRequests(new int[]{20, 30, 100, 110, 120});
    }

    /**
     * 分析：
     * 1 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
     * 1-1 age[y] <= 0.5 * age[x] + 7 （y 应该大于 x的一半年龄 + 7 岁。注意：由于是 大于 ，此处除法应该向下取整）
     * 1-2 age[y] > age[x] （y 不能大于x的年龄）
     * 1-3 age[y] > 100 && age[x] < 100 (由于上一条限制，不会出现此条的情况啊？？？)
     * <p>
     * 步骤：
     * 1 先对年龄数组进行排序，然后再遍历，当到到达边界时，则跳出循环
     */
    public int numFriendRequests(int[] ages) {
        if (ages.length == 1) {
            return 0;
        }
        int sum = 0;
        Arrays.sort(ages);

        for (int i = 0; i < ages.length; i++) {
            int ageX = ages[i];
            // 计算最小值
            int min = ageX / 2 + 7;
            for (int j = 0; j < ages.length; j++) {
                // 不给自己发好友请求
                if (i == j) {
                    continue;
                }
                int ageY = ages[j];
                // age[y] <= 0.5 * age[x] + 7
                if (ageY <= min) {
                    continue;
                }
                // age[y] > age[x]
                if (ageY > ageX) {
                    break;
                }
                sum++;
            }
        }
        return sum;
    }
}

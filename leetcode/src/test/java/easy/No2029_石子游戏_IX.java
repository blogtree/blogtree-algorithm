package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/stone-game-ix/"></a>
 */
@Slf4j
public class No2029_石子游戏_IX {

    @Test
    public void test1() {
        assert stoneGameIX(new int[]{2, 1});
        assert !stoneGameIX(new int[]{2});
    }

    @Test
    public void test2() {
        assert !stoneGameIX(new int[]{5, 1, 2, 4, 3});
    }

    @Test
    public void test3() {
        assert stoneGameIX(new int[]{1, 1, 7, 10, 8, 17, 10, 20, 2, 10});
    }

    /**
     * 官方分析：https://leetcode-cn.com/problems/stone-game-ix/solution/shi-zi-you-xi-ix-by-leetcode-solution-kk5f/
     */
    public boolean stoneGameIX(int[] stones) {
        int type1 = 0, type2 = 0, type3 = 0;
        for (int val : stones) {
            int type = val % 3;
            if (type == 0) {
                type1++;
            } else if (type == 1) {
                type2++;
            } else {
                type3++;
            }
        }
        if (type1 % 2 == 0) {
            return type2 >= 1 && type3 >= 1;
        }
        return type2 - type3 > 2 || type3 - type2 > 2;
    }
}

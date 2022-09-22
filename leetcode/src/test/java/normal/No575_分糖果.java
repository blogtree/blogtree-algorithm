package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode-cn.com/problems/distribute-candies/"></a>
 */
@Slf4j
public class No575_分糖果 {

    @Test
    public void test1() {
        assert 3 == distributeCandies(new int[]{1, 1, 2, 2, 3, 3});
        assert 2 == distributeCandies(new int[]{1, 1, 2, 3});
        assert 1 == distributeCandies(new int[]{6, 6, 6, 6});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public int distributeCandies(int[] candyType) {
        Set<Integer> candyTypeSet = new HashSet<>(candyType.length);
        for (int i : candyType) {
            candyTypeSet.add(i);
        }
        if (candyTypeSet.size() > candyType.length / 2) {
            return candyType.length / 2;
        } else {
            return candyTypeSet.size();
        }
    }

}

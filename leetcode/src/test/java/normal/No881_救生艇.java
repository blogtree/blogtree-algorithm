package normal;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @see <a href="https://leetcode-cn.com/problems/boats-to-save-people/"></a>
 */
public class No881_救生艇 {

    @Test
    public void test1() {
        assert 1 == numRescueBoats(new int[]{1, 2}, 3);
    }

    @Test
    public void test2() {
        assert 3 == numRescueBoats(new int[]{3, 2, 2, 1}, 3);
    }

    @Test
    public void test3() {
        assert 4 == numRescueBoats(new int[]{3, 5, 3, 4}, 5);
    }


    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 1 || limit == 1) {
            return people.length;
        }

        // 排序
        Arrays.sort(people);

        // 组队
        int i = 0, j = people.length - 1;
        int count = 0;
        while (i <= j) {
            // 判断最后两个能否组队
            if (j > 0 && people[j] + people[j - 1] <= limit) {
                count++;
                j -= 2;
                continue;
            }
            // 判断最后一个和第一个能否组队
            if (people[j] + people[i] <= limit) {
                count++;
                j--;
                i++;
                continue;
            }
            // 第一个自己组队
            count++;
            j--;
        }

        return count;
    }
}

package label.array.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @see <a href=""></a>
 */
@Slf4j
public class No599_两个列表的最小索引总和 {

    @Test
    public void test1() {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] list3 = findRestaurant(list1, list2);
        System.out.println(list3);
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        int minIndexSum = list1.length + list2.length;
        List<String> resList = new LinkedList<>();
        for (int i = 0; i < list2.length; i++) {
            String key = list2[i];
            if (map1.containsKey(key)) {
                Integer index1 = map1.get(key);
                if (minIndexSum > index1 + i) {
                    resList.clear();
                    minIndexSum = index1 + i;
                    resList.add(key);
                } else if (minIndexSum == index1 + i) {
                    minIndexSum = index1 + i;
                    resList.add(key);
                }
            }
        }
        return resList.toArray(new String[0]);
    }
}



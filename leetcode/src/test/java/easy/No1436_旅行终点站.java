package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/destination-city/"></a>
 */
@Slf4j
public class No1436_旅行终点站 {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public String destCity(List<List<String>> paths) {
        List<String> pathToList = new LinkedList();
        for (int i = 0; i < paths.size(); i++) {
            List<String> path = paths.get(i);
            if (!pathToList.contains(path.get(1))) {
                pathToList.add(path.get(1));
            }
        }
        for (int i = 0; i < paths.size(); i++) {
            List<String> path = paths.get(i);
            if (pathToList.contains(path.get(0))) {
                pathToList.remove(path.get(0));
            }
        }
        return pathToList.get(0);
    }
}

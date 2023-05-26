package util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LeetCodeUtil {


    @Test
    public void formatTitle() {
        String title = "495. 提莫攻击";
        title = title.replace(" ", "");
        title = title.replace(".", "_");
        log.info("title = No{}", title);
    }

    public String formatArray(String arrayStr) {
        String leetCodeStr = "[1,4,7,11,15]";
        String javaStr = leetCodeStr;
        javaStr = javaStr.replace("[", "{");
        javaStr = javaStr.replace("],", "}");
        log.info("javaStr = {}", javaStr);
        return javaStr;
    }

    /**
     * 将LeetCode的二位数组，转化为Java的二维数组
     *
     * @param doubleDimensionalArrayStr [[1,2,3],[4,5,6]]
     * @return {{1,2,3},{4,5,6}}
     */
    public String formatDoubleDimensionalArray(String doubleDimensionalArrayStr) {
        String javaStr = doubleDimensionalArrayStr;
        javaStr = javaStr.replace("[", "{");
        javaStr = javaStr.replace("],", "},");
        javaStr = javaStr.replace("]", "}");
        log.info("javaStr = new int[][]{}", javaStr);
        return javaStr;
    }

    @Test
    public void formatDoubleDimensionalArrayTest() {
        String doubleDimensionalArrayStr = "[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]";
        formatDoubleDimensionalArray(doubleDimensionalArrayStr);
    }
}

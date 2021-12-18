package util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LeetCodeWordUtil {


    @Test
    public void leetCodeArrFormat() {
        String leetCodeStr = "[1,4,7,11,15]";
        String javaStr = leetCodeStr;
        javaStr = javaStr.replace("[", "{");
        javaStr = javaStr.replace("],", "}");
        log.info("javaStr = {}", javaStr);
    }

    @Test
    public void leetCode2dArrFormat() {
//        String leetCodeStr = "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]";
        String leetCodeStr = "[[\"X\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"]]";
        String javaStr = leetCodeStr;
        javaStr = javaStr.replace("[", "{");
        javaStr = javaStr.replace("],", "},\r\n");
        javaStr = javaStr.replace("]", "}");
        log.info("javaStr = {}", javaStr);
    }
}

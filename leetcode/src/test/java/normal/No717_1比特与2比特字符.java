package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/"></a>
 */
@Slf4j
public class No717_1比特与2比特字符 {

    @Test
    public void test1() {
        assert isOneBitCharacter(new int[]{1, 0, 0});
        assert !isOneBitCharacter(new int[]{1, 1, 1, 0});
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 标签：数组
     * 分析：正序遍历，遇到1走两步，遇到0走一步。走到最后，看i是否等于数组长度 - 1
     */
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1 && bits[0] == 0) {
            return true;
        }
        if (bits[bits.length - 1] == 1) {
            return false;
        }
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i += 1;
            } else {
                i += 2;
            }
        }
        return i == bits.length - 1;
    }
}

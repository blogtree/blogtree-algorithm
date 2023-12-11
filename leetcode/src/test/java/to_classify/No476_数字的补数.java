package to_classify;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/number-complement/"></a>
 */
@Slf4j
public class No476_数字的补数 {

    @Test
    public void test1() {
        assert 2 == findComplement(5);
        assert 0 == findComplement(1);
    }

    @Test
    public void test2() {
        assert 0 == findComplement(Integer.MAX_VALUE);
    }

    @Test
    public void test3() {
    }

    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        binary = binary.replace("0", "2");
        binary = binary.replace("1", "0");
        binary = binary.replace("2", "1");
        Integer complement = Integer.parseInt(binary, 2);
        return complement;
    }
}

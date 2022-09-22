import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/first-bad-version/"></a>
 * <p>
 * 二分查找 交互
 */
@Slf4j
public class No278_第一个错误的版本 {

    private int minBadVersion;

    @Test
    public void test1() {
        minBadVersion = 4;
        assert 4 == firstBadVersion(5);
    }

    @Test
    public void test2() {
        minBadVersion = 1;
        assert 1 == firstBadVersion(1);
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：利用二分查找，查找第一个错误的版本
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // 如果是错误版本，则向左继续查找
                right = mid - 1;
            } else {
                // 如果不是错误版本，则向右继续查找
                left = mid + 1;
            }
        }
        return left;
    }


    boolean isBadVersion(int version) {
        return version >= minBadVersion;
    }
}

package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @see <a href="https://leetcode-cn.com/problems/find-the-town-judge/"></a>
 */
@Slf4j
public class No997_找到小镇的法官 {

    @Test
    public void test1() {

    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    /**
     * 分析：
     * 1 小镇的法官不相信任何人。 -> 法官不能是信任人
     * 2 每个人（除了小镇法官外）都信任小镇的法官。 ->法官需要为被信任人，而且出现次数为 N-1次
     * 步骤：
     * 1-1 判断入参是否只有一个人，而且不信任其他人
     * 1-2 判断trust的数量是否小于 N-1，如果小于，则返回-1
     * 2 创建2个set、1个map：信任人set（不能包含法官）、被信任人set（可能会包含法官）被信任人map（存储被信任的人数）
     * 3 遍历trust，存储上一步的2个set和1个map
     * 4 遍历 被信任人set，找到符合条件的法官
     */
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) {
            return 1;
        }

        Set<Integer> trustSet = new HashSet<>(n);
        HashSet<Integer> trustedSet = new HashSet<>(n);
        Map<Integer, Integer> trustCountMap = new HashMap<>();

        int trustId;
        int trustedId;
        for (int i = 0; i < trust.length; i++) {
            trustId = trust[i][0];
            trustedId = trust[i][1];
            trustSet.add(trustId);

            // 如果当前被信任人，之前信任过其他人，则跳过
            if (trustSet.contains(trustedId)) {
                continue;
            }

            trustedSet.add(trustedId);

            Integer trustCount = trustCountMap.get(trustedId);
            if (trustCount == null) {
                trustCountMap.put(trustedId, 1);
            } else {
                trustCountMap.put(trustedId, trustCount + 1);
            }
        }

        for (Integer trusted : trustedSet) {
            if (trustSet.contains(trusted)) {
                continue;
            }
            Integer trustCount = trustCountMap.get(trusted);
            if (trustCount != null && trustCount == n - 1) {
                return trusted;
            }
        }
        return -1;
    }
}

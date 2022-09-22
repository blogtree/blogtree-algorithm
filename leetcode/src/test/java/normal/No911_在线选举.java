package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode-cn.com/problems/online-election/"></a>
 */
@Slf4j
public class No911_在线选举 {

    @Test
    public void test1() {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        assert 0 == topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
        assert 1 == topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
        assert 1 == topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
        assert 0 == topVotedCandidate.q(15); // 返回 0
        assert 0 == topVotedCandidate.q(24); // 返回 0
        assert 1 == topVotedCandidate.q(8); // 返回 1
    }

    @Test
    public void test2() {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 0, 1, 1}, new int[]{24, 29, 31, 76, 81});
        assert 1 == topVotedCandidate.q(81);
    }

    @Test
    public void test3() {
    }

    class TopVotedCandidate {

        private int[] topVoteds;
        private int[] times;

        private TreeMap<Integer, PersonVotedInfo> personVotedMap = new TreeMap<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            this.topVoteds = new int[persons.length];
            this.times = times;

            for (int i = 0; i < persons.length; i++) {
                int person = persons[i];
                PersonVotedInfo info = personVotedMap.get(person);
                if (info == null) {
                    info = new PersonVotedInfo(person, 1, i);
                    personVotedMap.put(person, info);
                } else {
                    info.lastIndex = i;
                    info.votedCount++;
                }

                // 获取此时的领先的候选人
                PersonVotedInfo top = getTopNow();
                topVoteds[i] = top.person;
            }
        }

        private PersonVotedInfo getTopNow() {
            PersonVotedInfo maxInfo = null;
            for (Map.Entry<Integer, PersonVotedInfo> entry : personVotedMap.entrySet()) {
                if (maxInfo == null) {
                    maxInfo = entry.getValue();
                } else {
                    if (entry.getValue().votedCount > maxInfo.votedCount) {
                        maxInfo = entry.getValue();
                    } else if (entry.getValue().votedCount == maxInfo.votedCount) {
                        if (entry.getValue().lastIndex > maxInfo.lastIndex) {
                            maxInfo = entry.getValue();
                        }
                    }
                }
            }
            return maxInfo;
        }

        public int q(int t) {
            for (int i = 0; i < times.length; i++) {
                if (t < times[i]) {
                    return topVoteds[i - 1];
                }
            }
            // 返回最后一个时间点的结果
            return topVoteds[times.length - 1];
        }

        private class PersonVotedInfo {

            private int person;

            private int votedCount = 0;

            private int lastIndex = 0;

            public PersonVotedInfo(int person, int votedCount, int lastIndex) {
                this.person = person;
                this.votedCount = votedCount;
                this.lastIndex = lastIndex;
            }
        }
    }
}

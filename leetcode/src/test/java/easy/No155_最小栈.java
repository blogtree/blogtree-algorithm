package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @see <a href="https://leetcode-cn.com/problems/min-stack/"></a>
 */
@Slf4j
public class No155_最小栈 {

    @Test
    public void test1() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assert -3 == minStack.getMin();
        minStack.pop();
        assert 0 == minStack.top();
        assert -2 == minStack.getMin();
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    class MinStack {

        private LinkedList<Integer> list;

        public MinStack() {
            list = new LinkedList<>();
        }

        public void push(int val) {
            list.push(val);
        }

        public void pop() {
            list.pop();
        }

        public int top() {
            return list.getFirst();
        }

        public int getMin() {
            if (list.size() == 0) {
                return 0;
            }
            Integer min = list.get(0);
            for (Integer item : list) {
                if (min > item) {
                    min = item;
                }
            }
            return min;
        }
    }

}

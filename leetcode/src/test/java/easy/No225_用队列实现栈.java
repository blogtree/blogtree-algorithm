package easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @see <a href="https://leetcode-cn.com/problems/implement-stack-using-queues/"></a>
 */
@Slf4j
public class No225_用队列实现栈 {

    @Test
    public void test1() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        assert 2 == myStack.top(); // 返回 2
        assert 2 == myStack.pop(); // 返回 2
        assert !myStack.empty(); // 返回 False
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    class MyStack {

        private LinkedList<Integer> list;
        private LinkedList<Integer> listTemp;

        public MyStack() {
            list = new LinkedList<>();
            listTemp = new LinkedList<>();
        }

        public void push(int x) {
            listTemp = list;
            list = new LinkedList<>();
            list.add(x);
            list.addAll(listTemp);
        }

        public int pop() {
            return list.pop();
        }

        public int top() {
            return list.getFirst();
        }

        public boolean empty() {
            return list.isEmpty();
        }
    }
}

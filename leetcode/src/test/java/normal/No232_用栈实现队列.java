package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Stack;

/**
 * @see <a href="https://leetcode-cn.com/problems/implement-queue-using-stacks/"></a>
 */
@Slf4j
public class No232_用栈实现队列 {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    class MyQueue {

        private Stack<Integer> stack;
        private Stack<Integer> stackTemp;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack();
            stackTemp = new Stack();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stackTemp = stack;

            stack = new Stack();
            stack.push(x);

            for (Integer item : stackTemp) {
                stack.push(item);
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return stack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.empty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}

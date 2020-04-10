package joohoyo.leetcode.challenge._30day;

// Min Stack
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3292/
// 00:35 ~ 00:48 (13min)

import java.util.ArrayList;
import java.util.List;

public class C_MinStack {
    public static void main(String[] args) {
        new C_MinStack().test();
    }

    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      // Returns 0.
        System.out.println(minStack.getMin());   // Returns -2.
    }

    class MinStack {
        /**
         * Your MinStack object will be instantiated and called as such:
         * MinStack obj = new MinStack();
         * obj.push(x);
         * obj.pop();
         * int param_3 = obj.top();
         * int param_4 = obj.getMin();
         */
        List<Integer[]> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            this.stack = new ArrayList<>();
        }

        public void push(int x) {
            if (stack.size() == 0) {
                stack.add(new Integer[]{x, x});
            } else {
                int min = Math.min(stack.get(stack.size() - 1)[1], x);
                stack.add(new Integer[]{x, min});
            }
        }

        public void pop() {
            if (stack.size() == 0) {
                return;
            }
            stack.remove(stack.size() - 1);
        }

        public int top() {
            if (stack.size() == 0) {
                return 0;
            }
            return stack.get(stack.size() - 1)[0];
        }

        public int getMin() {
            if (stack.size() == 0) {
                return 0;
            }
            return stack.get(stack.size() - 1)[1];
        }
    }

}

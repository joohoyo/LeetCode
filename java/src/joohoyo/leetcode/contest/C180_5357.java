package joohoyo.leetcode.contest;

// 5357. Design a Stack With Increment Operation
// https://leetcode.com/contest/weekly-contest-180/problems/design-a-stack-with-increment-operation/
// 12:44 ~ 12:55 (11min)

public class C180_5357 {
    public static void main(String[] args) {
        new C180_5357().test();
    }

    /**
     * Your CustomStack object will be instantiated and called as such:
     * CustomStack obj = new CustomStack(maxSize);
     * obj.push(x);
     * int param_2 = obj.pop();
     * obj.increment(k,val);
     */
    public void test() {
        CustomStack customStack = new CustomStack(3); // Stack is Empty []
        customStack.push(1);                          // stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.push(3);                          // stack becomes [1, 2, 3]
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
        customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
        customStack.pop();                            // return -1 --> Stack is empty return -1.
    }

    class CustomStack {

        int[] stacks;
        int maxSize;
        int head = 0;

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            this.stacks = new int[maxSize];
        }

        public void push(int x) {
            if (this.head == this.maxSize) {
                return;
            }
            this.stacks[head++] = x;
        }

        public int pop() {
            if (head == 0) {
                return -1;
            }
            return this.stacks[--head];
        }

        public void increment(int k, int val) {
            for (int i = 0; i < Math.min(k, head); i++) {
                this.stacks[i] += val;
            }
        }
    }

}

package leetcode;

import java.util.Stack;

public class WeeklyContest4 {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public WeeklyContest4() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.empty() || x<=minStack.peek()) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek()==minStack.peek()) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    public static void main(String[] args) {
        WeeklyContest4 weeklyContest4 = new WeeklyContest4();
        weeklyContest4.push(512);
        weeklyContest4.push(-1024);
        weeklyContest4.push(-1024);
        weeklyContest4.push(512);

        weeklyContest4.pop();
        System.out.println(weeklyContest4.getMin());
        weeklyContest4.pop();
        System.out.println(weeklyContest4.getMin());
        weeklyContest4.pop();
        System.out.println(weeklyContest4.getMin());
    }
}

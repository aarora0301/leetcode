package main.java.AmazonFAQ.stackAndQueue;

import java.util.Stack;

public class MinStack {


    Stack<Integer> stack;
    Stack<Integer> minStack;

    MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() <= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if (minStack.peek() == x) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

    }
}

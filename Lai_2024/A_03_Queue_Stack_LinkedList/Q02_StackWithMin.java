package A_03_Queue_Stack_LinkedList;

import java.util.Stack;

public class Q02_StackWithMin {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Q02_StackWithMin() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        minStack.pop();
        return stack.pop();
    }

    public void push(int element) {
        stack.push(element);
        if (minStack.isEmpty()) {
            minStack.push(element);
        } else {
            minStack.push(Math.min(element, minStack.peek()));
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int min() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}

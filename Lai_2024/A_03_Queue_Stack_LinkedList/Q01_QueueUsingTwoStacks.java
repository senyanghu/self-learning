package A_03_Queue_Stack_LinkedList;

import java.util.Stack;

public class Q01_QueueUsingTwoStacks {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public Q01_QueueUsingTwoStacks() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public Integer poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.isEmpty() ? null : out.pop();
    }

    public void offer(int element) {
        in.push(element);
    }

    public Integer peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.isEmpty() ? null : out.peek();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }
}

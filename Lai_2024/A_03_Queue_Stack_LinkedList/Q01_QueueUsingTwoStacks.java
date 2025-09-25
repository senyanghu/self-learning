package A_03_Queue_Stack_LinkedList;

// Stack is deprecated
// import java.util.Stack; 
import java.util.ArrayDeque;
import java.util.Deque;

public class Q01_QueueUsingTwoStacks {
    private Deque<Integer> in;
    private Deque<Integer> out;

    public Q01_QueueUsingTwoStacks() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
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

    public static void main(String[] args) {
        Q01_QueueUsingTwoStacks queue = new Q01_QueueUsingTwoStacks();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println("Peek: " + queue.peek()); // Should print 1
        System.out.println("Poll: " + queue.poll()); // Should print 1
        System.out.println("Poll: " + queue.poll()); // Should print 2
        System.out.println("Is empty? " + queue.isEmpty()); // Should print false
        System.out.println("Poll: " + queue.poll()); // Should print 3
        System.out.println("Is empty? " + queue.isEmpty()); // Should print true
        System.out.println("Poll: " + queue.poll()); // Should print null
    }
}

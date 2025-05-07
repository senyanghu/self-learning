package MongoDB;

import java.util.LinkedList;
import java.util.Queue;

public class Q09_HitCounter {
    private Queue<Integer> queue;

    public Q09_HitCounter() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while(!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.poll();
        }
        return queue.size();
    }
}

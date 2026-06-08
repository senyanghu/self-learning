package Interview.Airbnb;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class LocalPair {
    int number;
    int priority;
    public LocalPair(int number, int priority) {
        this.number = number;
        this.priority = priority;
    }
}

public class TopKFrequentWords {
    public List<int[]> topKFrequent(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        
        List<int[]> result = new ArrayList<>();

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<LocalPair> minHeap = new PriorityQueue<>((p1, p2) -> p1.priority - p2.priority);
        
        for (int i = 0; i < arr.length; i++) {

            if (!frequencyMap.containsKey(arr[i])) {
                minHeap.offer(new LocalPair(arr[i], i));
            }

            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        while (!minHeap.isEmpty()) {
            LocalPair localPair = minHeap.poll();

            int[] resPair = new int[2];
            int number = localPair.number;
            System.out.println("number: " + number);
            int frequency = frequencyMap.get(number);
            System.out.println("frequency: " + frequency);
            resPair[0] = frequency;
            resPair[1] = number;
            result.add(resPair);
        }

        return result;
    }

    public static void main(String args[]) {
        int[] arr = {10, 10, 10, 10, 10, 5, 5, 5, 10};
        TopKFrequentWords topK = new TopKFrequentWords();
        List<int[]> result = topK.topKFrequent(arr);
        for (int[] res : result) {
            System.out.println(res[0] + " " + res[1]);
        }
    }
}

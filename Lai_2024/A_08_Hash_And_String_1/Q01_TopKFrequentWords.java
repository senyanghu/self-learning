package A_08_Hash_And_String_1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair {
    String word;
    int freq;

    Pair(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
}

public class Q01_TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        if (combo == null || combo.length == 0 || k <= 0) {
            return new String[0];
        }
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : combo) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> {
            if (p1.freq == p2.freq) {
                return 0;
            } else if (p1.freq < p2.freq) {
                return -1;
            } else {
                return 1;
            }
        });

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            minHeap.add(pair);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        String[] result = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().word;
        }
        return result;
    }

    public static void main(String args[]) {
        Q01_TopKFrequentWords topK = new Q01_TopKFrequentWords();
        String[] combo = {"Jessi", "Jessi", "Jessi", "Nick", "David", "Jon", "Jon"};
        String[] res = topK.topKFrequent(combo, 2);
        for (String str : res) {
            System.out.println(str);
        }
    }
}

/**
 * 让我从概念和思想层面解释 Map 和 Reduce：
 *
 * Map 的核心思想：
 *
 * Map = 分而治之（Divide）
 * - 把大问题拆分成许多小问题
 * - 每个小问题独立处理
 * - 可以并行执行
 *
 *
 *
 *
 * 举例1 - 统计单词：
 *
 *
 * 原始文本：
 * "hello world hello hadoop"
 *
 * Map操作：
 * mapper1: "hello" -> (hello, 1), (world, 1)
 * mapper2: "hello hadoop" -> (hello, 1), (hadoop, 1)
 *
 * 本质：把大文件拆分成小片段，每个mapper独立处理自己的那一片
 *
 *
 *
 *
 * 举例2 - 计算平均分：
 *
 *
 * 原始数据：
 * "Tom 90", "Jerry 85", "Tom 95", "Jerry 90"
 *
 * Map操作：
 * mapper1: "Tom 90" -> (Tom, [90])
 *          "Jerry 85" -> (Jerry, [85])
 * mapper2: "Tom 95" -> (Tom, [95])
 *          "Jerry 90" -> (Jerry, [90])
 *
 * 本质：把学生成绩数据拆分，每个mapper处理部分数据
 *
 *
 *
 *
 * Reduce 的核心思想：
 *
 * Reduce = 合并结果（Conquer）
 * - 收集相同key的所有值
 * - 对这些值进行归并处理
 * - 产生最终结果
 *
 *
 *
 *
 * 继续上面的例子：
 *
 * 单词统计的Reduce：
 *
 *
 * Reduce收到的输入：
 * (hello, [1,1])    -> (hello, 2)
 * (world, [1])      -> (world, 1)
 * (hadoop, [1])     -> (hadoop, 1)
 *
 * 本质：合并同一个单词的所有计数
 *
 *
 *
 *
 * 平均分计算的Reduce：
 *
 *
 * Reduce收到的输入：
 * (Tom, [90,95])    -> (Tom, 92.5)
 * (Jerry, [85,90])  -> (Jerry, 87.5)
 *
 * 本质：计算每个学生的平均分
 *
 *
 *
 *
 * MapReduce 的设计哲学：
 *
 * 1) 数据本地性处理
 *    - 移动计算而不是移动数据
 *    - 每个mapper处理本地数据
 *
 * 2) 键值对模型
 *    - Map: (key1, value1) -> list(key2, value2)
 *    - Reduce: (key2, list(value2)) -> list(key3, value3)
 *
 * 3) 并行计算
 *    - 多个mapper同时处理不同数据片段
 *    - 多个reducer同时处理不同key的数据
 *
 * public class TopKMapReduce {
 *     // 1. Mapper: 每个mapper找出局部的top k
 *     public static class TopKMapper
 *         extends Mapper<LongWritable, Text, NullWritable, Text> {
 *
 *         private PriorityQueue<Product> minHeap;
 *         private int k;
 *
 *         @Override
 *         protected void setup(Context context) {
 *             k = context.getConfiguration().getInt("k", 10);
 *             minHeap = new PriorityQueue<>((a, b) -> a.sales - b.sales);
 *         }
 *
 *         @Override
 *         public void map(LongWritable key, Text value, Context context) {
 *             // 解析输入：productId,sales
 *             String[] fields = value.toString().split(",");
 *             Product product = new Product(
 *                 fields[0],
 *                 Integer.parseInt(fields[1])
 *             );
 *
 *             // 维护大小为k的最小堆
 *             minHeap.offer(product);
 *             if (minHeap.size() > k) {
 *                 minHeap.poll();
 *             }
 *         }
 *
 *         @Override
 *         protected void cleanup(Context context)
 *             throws IOException, InterruptedException {
 *             // 输出局部top k
 *             while (!minHeap.isEmpty()) {
 *                 Product product = minHeap.poll();
 *                 context.write(
 *                     NullWritable.get(),
 *                     new Text(product.id + "," + product.sales)
 *                 );
 *             }
 *         }
 *     }
 *
 *     // 2. Reducer: 合并所有mapper的结果，找出全局top k
 *     public static class TopKReducer
 *         extends Reducer<NullWritable, Text, NullWritable, Text> {
 *
 *         private PriorityQueue<Product> minHeap;
 *         private int k;
 *
 *         @Override
 *         protected void setup(Context context) {
 *             k = context.getConfiguration().getInt("k", 10);
 *             minHeap = new PriorityQueue<>((a, b) -> a.sales - b.sales);
 *         }
 *
 *         @Override
 *         public void reduce(NullWritable key, Iterable<Text> values,
 *                          Context context)
 *             throws IOException, InterruptedException {
 *             // 处理所有mapper的输出
 *             for (Text value : values) {
 *                 String[] fields = value.toString().split(",");
 *                 Product product = new Product(
 *                     fields[0],
 *                     Integer.parseInt(fields[1])
 *                 );
 *
 *                 minHeap.offer(product);
 *                 if (minHeap.size() > k) {
 *                     minHeap.poll();
 *                 }
 *             }
 *
 *             // 输出最终结果（逆序）
 *             List<Product> result = new ArrayList<>();
 *             while (!minHeap.isEmpty()) {
 *                 result.add(0, minHeap.poll());
 *             }
 *
 *             for (Product product : result) {
 *                 context.write(
 *                     NullWritable.get(),
 *                     new Text(product.id + "," + product.sales)
 *                 );
 *             }
 *         }
 *     }
 * }
 */

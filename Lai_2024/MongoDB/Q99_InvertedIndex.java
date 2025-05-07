package MongoDB;

/*
Part 1:
对于一些input doc(String)，如:
“Pizza delivery service”
"Pizza is delicious"
search "pizza" 应返回 {“Pizza delivery service”, "Pizza is delicous"}
实现两个方法：
add(String doc)
List<String> search(String word)

Part 2:
实现 delete(String doc)


Part 3:
实现 advancedSearch(List<String> words, String operator)
Operator can be “AND”, “OR”
比如 advancedSearch {“pizza”, "delivery"}, AND
应返回 {“Pizza delivery service”}

Part 4:
ask what happen to multiple thread try to add and delete at same time, how to prevent issue

Data race:
* HashMap is not threadsafe
* concurrentModificationException

Inconsistency state:
* 例如，一个线程可能在另一个线程完成 add 操作的中途执行 search，导致看到部分更新的数据。



        // 模拟多线程访问 (仅用于演示，实际应用中需要创建并启动多个线程)
        Runnable adder1 = () -> ii.add("New pizza document");
        Runnable deleter1 = () -> ii.delete("Pizza is delicious");
        Runnable searcher1 = () -> System.out.println("Search 'pizza': " + ii.search("pizza"));

        Thread t1 = new Thread(adder1);
        Thread t2 = new Thread(deleter1);
        Thread t3 = new Thread(searcher1);

        t1.start();
        t2.start();
        t3.start();

特性             | synchronized     | ConcurrentHashMap             | ReentrantLock
--------------- |------------------|-------------------------------|-----------------
实现难度         | 最简单             | 较简单 (但需注意 Value 的线程安全) | 较复杂
并发性能         | 较低 (粗粒度锁)     | 较高 (细粒度锁，读多写少场景优势明显)| 较高 (灵活控制)
锁的粒度         | 对象级别           | Map 的内部结构 (更细粒度)         | 代码块级别
阻塞行为         | 竞争锁的线程阻塞     | 读操作通常不阻塞，写操作局部阻塞    | 竞争锁的线程阻塞
灵活性           | 最低              | 较高                           | 最高
异常处理         | 隐式释放锁          | 依赖 Value 的实现              | 需在 finally 中显式释放锁
适用场景         | 低并发，简单性要求高  | 高并发，读多写少，需要较高吞吐量    | 复杂并发控制，需要灵活锁定策略


 */


import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.ReentrantLock;

public class Q99_InvertedIndex {
    private Map<String, Set<String>> invertedIndexMap;
    private ReentrantLock lock;

    public Q99_InvertedIndex() {
        this.invertedIndexMap = new HashMap<>();
        this.lock = new ReentrantLock();
    }

    public void add(String doc) {
        if (doc == null || doc.isEmpty()) {
            return;
        }

        // lock.lock();
        // try {...} and then finally{lock.unlock(); }
        String[] words = doc.toLowerCase().split("\\s+");

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z0-9]", "");

            if (!word.isEmpty()) {
                this.invertedIndexMap.computeIfAbsent(word, k -> new HashSet<>()).add(doc);
//          Set<String> docs = invertedIndexMap.getOrDefault(word, new HashSet<>());
//          docs.add(doc);
//          invertedIndexMap.put(word, docs);
//          invertedIndexMap.computeIfAbsent(word, k -> new ConcurrentSkipListSet<>()).add(doc);
            }
        }
    }

    public List<String> search(String word) {
        if (word == null || word.isEmpty()) {
            return Collections.emptyList();
        }
        word = word.toLowerCase();
        Set<String> result = invertedIndexMap.getOrDefault(word, Collections.emptySet());
        return new ArrayList<>(result);
    }

    public void delete(String doc) {
        if (doc == null || doc.isEmpty()) {
            return;
        }

        String[] words = doc.toLowerCase().split("\\s+");
        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z0-9]", "");
            if (!word.isEmpty()) {
                uniqueWords.add(word);
            }
        }

        for (String word : uniqueWords) {
            Set<String> docs = this.invertedIndexMap.get(word);
            if (docs != null) {
                docs.remove(doc);
                if (docs.isEmpty()) {
                    this.invertedIndexMap.remove(word);
                }
            }
        }
    }

    public List<String> advancedSearch(List<String> words, String operator) {
        if (words == null || words.isEmpty()) {
            return Collections.emptyList();
        }

        // Handle different operators
        if ("OR".equalsIgnoreCase(operator)) {
            return performOrSearch(words);
        } else if ("AND".equalsIgnoreCase(operator)) {
            return performAndSearch(words);
        } else {
            throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    private List<String> performOrSearch(List<String> words) {
        Set<String> resultSet = new HashSet<>();

        for (String word : words) {
            List<String> docs = search(word);
            resultSet.addAll(docs);
        }

        return new ArrayList<>(resultSet);
    }

    private List<String> performAndSearch(List<String> words) {
        if (words.isEmpty()) {
            return Collections.emptyList();
        }

        // Get documents for the first word
        String firstWord = words.get(0);
        Set<String> result = new HashSet<>(search(firstWord));

        // Intersect with documents for each additional word
        for (int i = 1; i < words.size(); i++) {
            String word = words.get(i);
            List<String> docs = search(word);

            // Keep only documents that contain both the current result and the new word
            result.retainAll(docs);

            // Early termination if no documents match the intersection
            if (result.isEmpty()) {
                break;
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String args[]) {
        Q99_InvertedIndex ii = new Q99_InvertedIndex();
        ii.add("Pizza delivery service");
        ii.add("Pizza is delicious");

        System.out.println("Search for 'pizza':");
        System.out.println(ii.search("pizza"));

        System.out.println("AND search for 'pizza' and 'delivery':");
        List<String> andWords = new ArrayList<>();
        andWords.add("pizza");
        andWords.add("delivery");
        System.out.println(ii.advancedSearch(andWords, "AND"));

        System.out.println("OR search for 'pizza' and 'delivery':");
        System.out.println(ii.advancedSearch(andWords, "OR"));

        System.out.println("Delete doc: 'Pizza is delicious'");
        ii.delete("Pizza is delicious");
        System.out.println("Search for 'pizza' after deletion:");
        System.out.println(ii.search("pizza"));
    }
}

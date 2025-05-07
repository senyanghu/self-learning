package MongoDB;

/*
You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.

Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records may be incorrect. Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.

Design an algorithm that:

Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
Finds the maximum price the stock has been based on the current records.
Finds the minimum price the stock has been based on the current records.
Implement the StockPrice class:

StockPrice() Initializes the object with no price records.
void update(int timestamp, int price) Updates the price of the stock at the given timestamp.
int current() Returns the latest price of the stock.
int maximum() Returns the maximum price of the stock.
int minimum() Returns the minimum price of the stock.

 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Stock {
    int timestamp;
    int price;

    Stock() {

    }

    Stock(int timestamp, int price) {
        this.timestamp = timestamp;
        this.price = price;
    }
}

public class Q12_StockPriceFluctuation {
    private PriorityQueue<Stock> minHeap;
    private PriorityQueue<Stock> maxHeap;
    private Map<Integer, Integer> timeToPriceMap;
    private Stock stock;

    public Q12_StockPriceFluctuation() {
        minHeap = new PriorityQueue<>((s1, s2) -> s1.price - s2.price);
        maxHeap = new PriorityQueue<>((s1, s2) -> s2.price - s1.price);
        timeToPriceMap = new HashMap<>();
        stock = new Stock();
    }

    public void update(int timestamp, int price) {
        timeToPriceMap.put(timestamp, price);

        if (timestamp >= stock.timestamp) {
            stock.timestamp = timestamp;
            stock.price = price;
        }

        Stock s = new Stock(timestamp, price);
        minHeap.add(s);
        maxHeap.add(s);
    }

    public int current() {
        return stock.price;
    }

    public int maximum() {
        while (!maxHeap.isEmpty()) {
            Stock s = maxHeap.peek();
            if (timeToPriceMap.get(s.timestamp) == s.price) {
                return s.price;
            } else {
                maxHeap.poll();
            }
        }
        return -1;
    }

    public int minimum() {
        while (!minHeap.isEmpty()) {
            Stock s = minHeap.peek();
            if (timeToPriceMap.get(s.timestamp) == s.price) {
                return s.price;
            } else {
                minHeap.poll();
            }
        }
        return -1;
    }
}

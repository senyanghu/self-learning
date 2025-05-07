package MongoDB;
/*
要求实现ConnectionPool的class，能够重复使用connection
Each request to get a connection should take one from the pool or create a new one if the pool is empty. The pool must be thread-safe
然后给了一个connection的class
提问： 在哪加锁更高效 注意 open connection is an expensive operation
 */

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Connection {
    public Connection() {
    }

    // Must be called once before any read/write calls.
    // This is an expensive operation.
    public void open() {
    }

    public String read() {
        return null;
    }

    public void write(String data) {
    }

    // After close is called, read/write may not be called.
    public void close() {
    }
}

public class Q96_ConnectionPool {
    // 当作是threadsafe版本的linkedlist
    private final ConcurrentLinkedQueue<Connection> pool;
    private final int maxPoolSize;
    private final AtomicInteger activeConnections;
    private final ReentrantLock createLock;

    public Q96_ConnectionPool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        this.pool = new ConcurrentLinkedQueue<>();
        this.activeConnections = new AtomicInteger(0);
        createLock = new ReentrantLock();
        for (int i = 0; i < Math.min(maxPoolSize, 5); i++) {
            Connection connection = new Connection();
            connection.open();
            pool.offer(connection);
            activeConnections.incrementAndGet();
        }
    }

    public Connection getConnection() {
        Connection connection = pool.poll();

        if (connection == null) {
            try {
                createLock.lock();
                connection = new Connection();
                connection.open();
                activeConnections.incrementAndGet();
            } finally {
                createLock.unlock();
            }
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection == null) {
            return;
        }

        if (pool.size() < maxPoolSize) {
            pool.offer(connection);
        } else {
            connection.close();
            activeConnections.decrementAndGet();
        }
    }

    public void shutdown() {
        Connection connection;
        while ((connection = pool.poll()) != null) {
            connection.close();
            activeConnections.decrementAndGet();
        }
    }
}

/*
public Connection getConnection() {
        Connection connection = pool.poll();

        if (connection == null && activeConnections.get() < maxPoolSize) {
            try {
                createLock.lock(); // 获取创建锁
                if (pool.isEmpty() && activeConnections.get() < maxPoolSize) {
                    connection = new Connection();
                    connection.open();
                    activeConnections.incrementAndGet();
                } else {
                    // 其他线程可能已经创建了连接，或者池中已经有连接了
                    connection = pool.poll();
                }
            } finally {
                createLock.unlock(); // 释放创建锁
            }
        }

        return connection;
    }
 */
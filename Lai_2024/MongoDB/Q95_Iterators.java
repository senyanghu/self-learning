package MongoDB;

import java.util.*;

class SimpleUnionIterator<T> implements Iterator<T> {
    private final Iterator<T> iterator1;
    private final Iterator<T> iterator2;
    private boolean useFirstIterator; // 标记当前使用哪个迭代器

    public SimpleUnionIterator(Iterator<T> iterator1, Iterator<T> iterator2) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.useFirstIterator = true; // 先使用第一个迭代器
    }
    
    @Override
    public boolean hasNext() {
        // 如果第一个迭代器还有元素，返回true
        if (useFirstIterator && iterator1.hasNext()) {
            return true;
        }

        // 如果第一个迭代器已经用完，切换到第二个
        useFirstIterator = false;

        // 检查第二个迭代器是否还有元素
        return iterator2.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // 根据当前使用的迭代器返回下一个元素
        if (useFirstIterator) {
            return iterator1.next();
        } else {
            return iterator2.next();
        }
    }
}

/**
 * 支持 n 个迭代器的合并迭代器 - 无去重
 */
class MultiUnionIteratorNoDedup<T> implements Iterator<T> {
    private final List<Iterator<T>> iterators;
    private int currentIndex; // 当前正在使用的迭代器索引

    /**
     * 构造函数
     *
     * @param iterators 迭代器列表
     */
    public MultiUnionIteratorNoDedup(List<Iterator<T>> iterators) {
        if (iterators == null || iterators.isEmpty()) {
            throw new IllegalArgumentException("迭代器列表不能为空");
        }
        this.iterators = new ArrayList<>(iterators);
        this.currentIndex = 0;
    }

    /**
     * 判断是否还有下一个元素
     */
    @Override
    public boolean hasNext() {
        // 查找有元素的迭代器
        while (currentIndex < iterators.size()) {
            if (iterators.get(currentIndex).hasNext()) {
                return true;
            }
            currentIndex++; // 当前迭代器用完，移动到下一个
        }
        return false; // 所有迭代器都没有元素了
    }

    /**
     * 获取下一个元素
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // 从当前迭代器获取下一个元素
        return iterators.get(currentIndex).next();
    }
}

/**
 * 测试类
 */
class UnionIteratorTest {
    public static void main(String[] args) {
        // 测试两个迭代器的情况
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        SimpleUnionIterator<Integer> unionIterator = new SimpleUnionIterator<>(list1.iterator(), list2.iterator());

        System.out.println("两个迭代器的合并（不去重）：");
        while (unionIterator.hasNext()) {
            System.out.print(unionIterator.next() + " ");
        }
        System.out.println(); // 输出: 1 2 3 4 3 4 5 6

        // 测试多个迭代器的情况
        List<Integer> list3 = Arrays.asList(5, 6, 7, 8);
        List<Iterator<Integer>> iterators = Arrays.asList(
                list1.iterator(), list2.iterator(), list3.iterator());

        MultiUnionIteratorNoDedup<Integer> multiUnionIterator = new MultiUnionIteratorNoDedup<>(iterators);

        System.out.println("多个迭代器的合并（不去重）：");
        while (multiUnionIterator.hasNext()) {
            System.out.print(multiUnionIterator.next() + " ");
        }
        System.out.println(); // 输出: 1 2 3 4 3 4 5 6 5 6 7 8
    }
}

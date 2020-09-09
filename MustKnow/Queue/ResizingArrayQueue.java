package MustKnow.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item> implements Iterable<Item> {
    private Item[] q;
    private int N;          // 队列中元素的数量
    private int first;      // 队头元素的下标
    private int last;       // 队尾元素的后一个位置的下标，也就是元素入列时可以放置的位置


    /**
     * 初始化队列，此时头尾下标重合
     */
    public ResizingArrayQueue() {
        q = (Item[]) new Object[2];
        N = 0;
        first = 0;
        last = 0;
    }

    /**
     * 依旧用N判断队列是否为空
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 队列中元素数量
     */
    public int size() {
        return N;
    }

    // 调整数组大小
    private void resize(int max) {
        assert max >= N;
        Item[] temp = (Item[]) new Object[max];
        //注意这里：把N个元素放入总大小为max的队列（max>=N）
        //因为循环使用数组，从first开始的第i个元素可能保存在了first
        //前面（即last在first前面）。
        for (int i = 0; i < N; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        //把小队列按顺序复制到大队列后重置队头和队尾
        first = 0;
        last = N;
    }

    /**
     * 元素入列
     */
    public void enqueue(Item item) {
        if (N == q.length) resize(2 * q.length);
        q[last++] = item;   // 元素入列
        if (last == q.length) last = 0;  // 如果last超出数组下标，把last置零，循环利用数组
        N++;
    }

    /**
     * 元素出列
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[first];
        q[first] = null;       // 防止对象游离
        N--;
        first++;
        if (first == q.length) first = 0; // 循环利用数组，下一个队头在下标为0的地方
        if (N > 0 && N == q.length / 4) resize(q.length / 2);
        return item;
    }

    /**
     * 返回队头元素但不出列
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return q[first];
    }

    /**
     * 实现Iterable接口
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    //实现迭代器
    private class ArrayIterator implements Iterator<Item> {
        //维护一个i用于迭代
        private int i = 0;

        public boolean hasNext() {
            return i < N;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        //直接利用first进行遍历，注意可能存在数组的循环利用
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }
}
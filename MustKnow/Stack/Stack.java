package MustKnow.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

//链表实现
public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;     //栈顶节点
    private int N;                // 栈内元素数量

    // 辅助类Node，用于形成链表
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * 初始化栈
     */
    public Stack() {
        first = null;
        N = 0;
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return first == null;
        //return N == 0;
    }

    /**
     * 返回栈内元素数量
     */
    public int size() {
        return N;
    }

    /**
     * 压入元素
     */
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    /**
     * 弹出元素
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // 需弹出的元素
        first = first.next;            // 删除头节点
        N--;
        return item;
    }


    /**
     * 返回但不弹出元素
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * 从栈顶到栈底打印元素
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }


    /**
     * 实现Iterable接口
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    // 实现Iterator接口用于迭代，没有实现remove方法
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        //初始化时，current指向栈顶
        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

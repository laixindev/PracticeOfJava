package MustKnow.Stack;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[]a; //栈顶为最大下标
    private int n;

    public ResizingArrayStack(){
        a = (Item[]) new Object[2];
        n =0;
    }
    public boolean isEmpty(){
        return n==0;
    }
    public int size(){
        return n;
    }
    public void resize(int capacity){
        assert capacity >= n;
        //注意不能直接创建泛型数组,resize相当于新建一个指定格式的数组，然后把原有的数组复制过去
        Item[] temp = (Item[]) new Object[capacity];
        for(int i= 0 ;i<n;i++){
            temp[i] = a[i];
        }
        a = temp;
        //也可以用a = Arrays.copyOf(a,capacity)
    }
    public void push(Item item){
        if(n == a.length) resize(2*a.length);
        a[n++] = item;
    }
    public Item pop() throws NoSuchFieldException {
        if(isEmpty()) throw new NoSuchFieldException("Stack overflow");
        Item item = a[n-1];
        a[n-1] = null;//防止对象游离
        n--;
        if(n>0 && n== a.length/4) resize(a.length/2);
        return item;
    }
    public Item peek() throws NoSuchFieldException {
        if(isEmpty()) throw new NoSuchFieldException("Stack overflow");
        return a[n-1];
    }

    //返回一个可以进行先进后出迭代的迭代器
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    // 用内部类实现迭代器接口，实现从栈顶往栈底的先进后出迭代，没有实现remove()方法。
    private class ReverseArrayIterator implements Iterator<Item>{
        private int i;
        public ReverseArrayIterator(){
            i = n-1;
        }
        public boolean hasNext(){
            return i >=0;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
        public Item next(){
            if(!hasNext()) try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            return a[i--];
        }

    }

}
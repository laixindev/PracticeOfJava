package MustKnow.Array;

public class DynamicArray {
    public class Array<E>{
        private int size; //数组中元素个数
        private E[] data; //数组声明
    }
    //构造方法
    public void Array(int capacity){
        data = (E[]) new Object[capacity];
        int size = 0;
    }
    public void Array(){
        this(10);
    }
    //基本方法
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //向数组指定位置添加元素，index为指定索引位置，e为添加的值
    public void add (int index, E e) {
    //索引位置不能让它瞎插，索引为负数，或者跳格子插，不可以。
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add is fail, require index < 0 || index > size");
        }
    //当数组容量满了的时候，调用扩容方法，此处给它扩当前数组长度的两倍。
        if (data.length == size) {
            this.resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }
    //新来的进坑
        data[index] = e;
    //维护size
        size ++;
    }
    //向数组第一位添加元素
    public void addFirst (E e) {
    //直接复用上一个add方法
        this.add(0, e);
    }
    //向数组最后一位添加元素
    public void addLast (E e) {
    //同理
        this.add(size, e);
    }

    //根据索引删除某个元素 返回删除的元素
    public E remove (int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove is fail,require index < 0 || index >= size");
        }
    //先把要删除的元素存起来，不然等会就给覆盖了。
        E value = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
    //维护size
        size --;
    //此处为什么设置为null呢，因为泛型的原因，传进来的都是类对象，数组中存的是引用地址，引用不断开的话，垃圾回收器没办法回收。
        data[size] = null;
    //此处缩容，当数组元素个数等于数组长度四分之一时，进行缩容if (size == data.length/4 && data.length / 2 != 0) {
    //缩容为数组长度的二分之一
        this.resize(data.length /2);
        return value;
    }
    //根据值删除某个元素
    public void removeByValue (E e) {
    //复用根据值查找元素的方法，返回索引（此方法在下面）
        int index = this.getByElement(e);
        if (index != -1) {
    //复用根据索引删除的方法
            this.remove(index);
        }
    }
    //删除第一个元素
    public E removeFirst () {
        return this.remove(0);
    }
    //删除最后一个元素
    public E removeLast () {
        return this.remove(size - 1);
    }

    //根据索引查找数组某个元素,返回值
    public E getByIndex (int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get is fail, require index < 0 || index >= size");
        }

        return data[index];
    }
    //根据值查找数组某个元素,返回索引
    public int getByElement (E e) {
    //本质：遍历数组进行比对
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e) ) {
                return i;
            }
        }
        return -1;
    }

    //是否包含该元素
    public boolean contains (E e) {
    //本质：遍历数组进行比对
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    //修改数组某个元素
    public void set (int index, E e) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set is fail, require index < 0 || index >= size");
        }

        data[index] = e;
    }
    //扩容
    private void resize (int newCatacity) {
        E[] newData = (E[])new Object[newCatacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
    //给成员变量data重新赋值新引用（后面有内存图介绍）
        data = newData;
    }

}





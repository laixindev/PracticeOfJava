package MustKnow.LinkedList;

public class Node {
    private Object data;
    private Node next;
    private Node befor;

    public Node() {

    }

    public Node(Object data) {
        super();//指代父类对象
        this.data = data;//this，当传入的参数的参数名与该类的成员变量名相同，并且把参数赋值给与之同名的成员变量时，
        // 此时编译器并不知道到底是参数赋值给成员变量，还是成员变量赋值给参数；这时编译器就会知道，是把传进来的参数赋值给成员变量。
    }

    public Node getBefor() {
        return befor;
    }

    public void setBefor(Node befor) {
        this.befor = befor;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

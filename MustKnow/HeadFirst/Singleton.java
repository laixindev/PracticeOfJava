package MustKnow.HeadFirst;

import java.text.SimpleDateFormat;

//hungry 在类加载时就初始化创建单例对象，线程安全，但不管是否使用都创建对象可能会浪费内存。
public class Singleton{
    private Singleton(){}
    private static Singleton instance= new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}
//lazy 在外部调用时才会加载，线程不安全，可以加锁保证线程安全但效率低。
//public class Singleton{
//    private Singleton(){}
//    private static Singleton instance ;
//    public static Singleton getInstance(){
//        if(instance==null){
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}
//使用 volatile 以及多重检查来减小锁范围，提升效率。
//doublecheck
//public class Singleton{
//    private Singleton(){}
//    private  volatile static Singleton instance ;
//    public static Singleton getInstance(){
//        if(instance ==null){
//            synchronized(Singleton.class){
//                if(instance==null){
//                    instance = new Singleton();
//                }
//            }
//        }
//
//        return instance;
//    }
//}


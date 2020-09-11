package MustKnow.HeadFirst;
//hungry
public class Singleton {
    private  Singleton(){}
    private  static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
//lazy
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


package KlauserJava.Singleton;

public class Singleton {
    // 静态成员变量，用于存储唯一实例
    private static Singleton uniqueInstance;
    // 私有化构造函数，防止外部类直接实例化
    private Singleton(){}
    //静态共有方法，返回唯一实例
    public  static Singleton getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}

package KlauserJava.Synchronized;

public class Service {
    public void doStepOne(){
        System.out.println(Thread.currentThread() + "Do Step One");
    }
    public void doStepTwo(){
        System.out.println(Thread.currentThread() + "Do Step Two");
    }
    public void doStepOneAndTwo(){
        synchronized (this){ // 可以传对象进去
            doStepOne();
            doStepTwo();
        }
    }
    public synchronized void doStep1And2(){ // 也可以作为关键词用在方法中
        doStepOne();
        doStepTwo();
    }
    public static void main(String[] args){
        Service service = new Service();
        service.doStepOneAndTwo();
        service.doStep1And2();

        new Thread(()->{ // 还可以在线程里用synchronized传对象进去
            synchronized (service){
                service.doStepOne();
                service.doStepTwo();
            }
        }).start();
    }
}

package KlauserJava.Asynchrone;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<String> task = ()->{
            Thread.sleep(100);
            return "Hallo";
        };
        Future<String> future = executor.submit(task);
        for(int i = 0; i < 5; i++){
            final  int index = i;
            executor.execute(() ->{
                System.out.println("Task" + index + "is running" + Thread.currentThread().getName());
            });
        }
        try{
            String result = future.get();
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown(); // 关闭服务
        }
    }
}

package KlauserJava.Asynchrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var exec = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Callable<Integer> cCals = ()->{
                return doVeryComplexCalculation();
            };
            var future = exec.submit(cCals);
            futures.add(future);
        }
        int sum = 0;
        for(var future : futures){
            sum += future.get();
        }
        System.out.println(sum);
        exec.shutdown();
    }
    public static int doVeryComplexCalculation(){
        return (int) (Math.random() * 100);
    }
}

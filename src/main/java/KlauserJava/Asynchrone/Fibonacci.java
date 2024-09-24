package KlauserJava.Asynchrone;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fibonacci {
    static final int n = 12;
    static final int sleepTime = 0;
    static ExecutorService exec = Executors.newCachedThreadPool();

    public static long serialFib(int n) {
        if (n <= 2) return 1;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return serialFib(n - 1) + serialFib(n - 2);
    }

    public static long parallelFib(int n) throws ExecutionException, InterruptedException {
        if (n <= 2) return 1;

        Thread.sleep(sleepTime);

        Callable<Long> nm1 = () -> parallelFib(n - 1);
        Callable<Long> nm2 = () -> parallelFib(n - 2);

        var future1 = exec.submit(() -> parallelFib(n - 1));
        var future2 = exec.submit(nm2);

        return future1.get() + future2.get();
    }

    public static void main(String[] args) {
        try {

            var start = Instant.now();
            var fib = serialFib(n);
            var end = Instant.now();
            var duration = Duration.between(start, end).toMillis();

            System.out.println("Normale Result: " + fib + ", computation time: " + duration);

            start = Instant.now();
            fib = parallelFib(n);
            end = Instant.now();
            duration = Duration.between(start, end).toMillis();
            System.out.println("Asynchrone Result: " + fib + ", computation time: " + duration);

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

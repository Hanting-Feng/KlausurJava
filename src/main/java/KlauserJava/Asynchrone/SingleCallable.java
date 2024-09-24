package KlauserJava.Asynchrone;

import java.util.concurrent.Callable;

public class SingleCallable implements Callable<String> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        return "Hallo from Callable";
    }
}

package executor;

import java.util.concurrent.*;

public class CallableExecutorTest {

    public static void main(String[] args) {
        Callable<Integer> callable = () -> {
            System.out.println("Callable : " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
            return 2;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> submit = executorService.submit(callable);
        try {
            System.out.println("Future done ? " + submit.isDone());
            Integer integer = submit.get();
            System.out.println("Future done ? " + submit.isDone());
            System.out.println("Value  :  " + integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Thread : " + Thread.currentThread().getName());
        executorService.shutdown();
    }
}

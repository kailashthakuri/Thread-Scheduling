package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable task = () -> {
            System.out.println("Hello : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };
        executorService.submit(task);
        try {
            executorService.shutdown();
            executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Task Interrupted");
        } finally {
            System.out.println("Is Terminated :  " + executorService.isTerminated());
            if (!executorService.isTerminated()) {
                System.out.println("Cancel  Non  Finished Tasks");
                executorService.shutdownNow();
            }
            System.out.println("Shutdown Finished");
        }

    }
}

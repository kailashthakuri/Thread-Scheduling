package executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CalllablesExecutorTest {

    public static void main(String[] args) {
        int threads = Runtime.getRuntime().availableProcessors() / 2;
        System.out.println(threads);

        List<Callable<String>> callables = Arrays.asList(
                () -> {
                    System.out.println(Thread.currentThread().getName());
                    return "Kailash";
                },
                () -> {
                    System.out.println(Thread.currentThread().getName());
                    return "Dipendra";
                },
                () -> {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName());
                    return "Nirajan";
                },
                () -> {
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println(Thread.currentThread().getName());
                    return "kshitij";
                });

        ExecutorService executorService = Executors.newWorkStealingPool();
        try {
            executorService.invokeAll(callables)
                    .stream()
                    .map(stringFuture -> {
                        try {
                            return stringFuture.get();
                        } catch (InterruptedException e) {
                            throw new IllegalArgumentException();
                        } catch (ExecutionException e) {
                            throw new IllegalArgumentException();
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }


    }
}

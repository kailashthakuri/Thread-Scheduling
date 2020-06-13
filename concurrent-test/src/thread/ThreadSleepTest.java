package thread;

import java.util.concurrent.TimeUnit;

public class ThreadSleepTest {
    public static void main(String[] args) {
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Thread Started : " + name);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {

            }
            System.out.println("Thread Ended : " + name);
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}

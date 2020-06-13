package scheduledexecutor;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayScheduledExecutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling : " + LocalDateTime.now());
            } catch (InterruptedException e) {
                System.out.println("Interruped");
            }
        };
        scheduledExecutorService.scheduleWithFixedDelay(task, 2, 1, TimeUnit.SECONDS);

    }
}

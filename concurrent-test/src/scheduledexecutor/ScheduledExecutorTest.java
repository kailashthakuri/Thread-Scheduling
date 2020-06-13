package scheduledexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduled : " + System.nanoTime());
        ScheduledFuture<?> schedule = scheduledExecutorService.schedule(task, 3, TimeUnit.SECONDS);
        try {
            TimeUnit.MILLISECONDS.sleep(1330);
        } catch (InterruptedException e) {
            System.out.println("Interrupted .");
        }
        long delay = schedule.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay %s ms", delay);
    }

}

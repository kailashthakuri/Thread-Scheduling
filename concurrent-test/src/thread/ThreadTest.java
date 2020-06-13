package thread;

public class ThreadTest {

    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        task.run();
        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done");
    }

}

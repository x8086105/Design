package homeconcurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 通过创建异步任务
 */
public class ThreadTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(() -> {
            int i = 1+1;
            Thread.sleep(6000);
            return "xx";
        });
        new Thread(task).start();
        //String s = task.get();
        System.out.println("ttttt");
    }
}

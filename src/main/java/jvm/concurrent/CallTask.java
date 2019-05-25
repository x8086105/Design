package jvm.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("tt");
        return "hello world";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new CallTask());
        Thread t = new Thread(futureTask);
        t.start();

        String s = futureTask.get();

        System.out.println("ssss");
        System.out.println("返回值是：");
    }
}

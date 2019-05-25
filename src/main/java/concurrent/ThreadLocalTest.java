package concurrent;

public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal threadLocal = new ThreadLocal();
        InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();

        inheritableThreadLocal.set("parent 2 value");
        inheritableThreadLocal.get();
        threadLocal.set("123456");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("xxxx");
                threadLocal.set("yyyy");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
                try {
                    Thread.sleep(2000);
                    System.out.println(inheritableThreadLocal.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        inheritableThreadLocal.set("parent 3 value");
        System.out.println("xxx"+inheritableThreadLocal.get());
    }
}

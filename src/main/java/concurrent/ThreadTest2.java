package concurrent;

public class ThreadTest2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+"I am a child Thread");
    }

    public static void main(String[] args) {
        ThreadTest2 threadTest2 = new ThreadTest2();
        Thread t = new Thread(threadTest2);
        Thread t2 = new Thread(threadTest2);
        t.setName("xxxx");
        t2.setName("ttttt");
        t.start();
        t2.start();

    }
}

package homeconcurrent;

public class ThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("I am  a child Thread");
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
        while (true){

        }
    }
}

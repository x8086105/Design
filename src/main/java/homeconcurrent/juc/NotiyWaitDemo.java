package homeconcurrent.juc;

/**
 * 操作初始值为0的变量，
 * 实现一个线程对该变量+1 另一个线程对该变量-1
 * 交替 来10次变量最终还是0
 */
public class NotiyWaitDemo {
    public static void main(String[] args) {
        ShareData sd = new ShareData();
        Thread thread1 = new Thread(() -> {
            for (int i= 0;i<100;i++){
                try {
                    sd.addI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AA");
        Thread thread2 = new Thread(() -> {
            for (int i= 0;i<100;i++){
                try {
                    sd.delI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BB");
        Thread thread3 = new Thread(() -> {
            for (int i= 0;i<100;i++){
                try {
                    sd.addI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"CC");
        Thread thread4 = new Thread(() -> {
            for (int i= 0;i<100;i++){
                try {
                    sd.delI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"DD");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

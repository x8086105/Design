package homeconcurrent.juc;

/**
 * 8锁测试
 *
 */
public class Lock8 {
   public static class Phone{
       public synchronized static void call(){
           System.out.println("Call");
       }
       public synchronized void call2() throws InterruptedException {
           Thread.sleep(20000 );
           System.out.println("Call2");
       }
   }

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    phone.call2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(2000 );
        new Thread(new Runnable() {
            @Override
            public void run() {
                Phone.call();
            }
        }).start();
    }
}



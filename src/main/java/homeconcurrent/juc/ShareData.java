package homeconcurrent.juc;

/**
 * 资源类
 */
public class ShareData {
    private  int i = 0;
    public synchronized  void addI(){
        //if(i!=0)
        while (i!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ++i;
        System.out.println(Thread.currentThread().getName()+"\t"+i);
        this.notifyAll();
    }
    public synchronized void delI(){
        while (i==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        --i;
        System.out.println(Thread.currentThread().getName()+"\t"+i);
        this.notifyAll();
    }
}

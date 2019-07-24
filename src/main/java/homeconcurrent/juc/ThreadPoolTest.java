package homeconcurrent.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.TimeUnit.*;

public class ThreadPoolTest {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(() -> System.out.println("xxxxx"));
//        System.out.println(COUNT_BITS);
//        System.out.println(CAPACITY);
//        System.out.println(RUNNING);
//        System.out.println(SHUTDOWN);
//        System.out.println(STOP);
//        System.out.println(TIDYING);
//        System.out.println(TERMINATED);
        AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
        System.out.println(ctl.get());
        System.out.println(workerCountOf(ctl.get()));
    }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    private static int workerCountOf(int c)  { return 10 & CAPACITY; }
}

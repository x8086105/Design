package homeconcurrent.juc;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkQueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedQueueSourceTest<String> clq = new ConcurrentLinkedQueueSourceTest<>();
        //向队尾添加元素
        clq.offer("第一个元素");
        clq.offer("第二个元素");
        clq.offer("第三个元素");
        clq.offer("第四个元素");
        clq.offer("第无个元素");
        clq.offer("第留个元素");
        //从队头获取并移除元素
        System.out.println(clq.poll());
        System.out.println(clq.poll());
        System.out.println(clq.poll());
        System.out.println(clq.poll());
        System.out.println(clq.poll());
        System.out.println(clq.poll());
        System.out.println(clq.size());
        System.out.println(Integer.SIZE);
    }
}

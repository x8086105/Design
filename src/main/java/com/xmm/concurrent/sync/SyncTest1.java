package com.xmm.concurrent.sync;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * 查看锁状态信息
 */
@Slf4j
public class SyncTest1 {

    public static void main(String[] args) throws InterruptedException {
        log.info("lock加锁前，打印的对象的头信息为:");
        Object o = new Object();
        String lockHeadInfo = ClassLayout.parseInstance(o).toPrintable();
        log.info(lockHeadInfo);

        Thread.sleep(5000);
        Object o2 = new Object();

        log.info(ClassLayout.parseInstance(o2).toPrintable());
        //调用synchronized之后，会进行锁撤销
       // o2.hashCode();
        log.info("开始使用synchronized进行上锁，观察当前对象的对象头是什么信息");
        log.info(ClassLayout.parseInstance(o2).toPrintable());
        Object o3 = new Object();
        synchronized (o2){
            log.info(ClassLayout.parseInstance(o2).toPrintable());
        }

    }
}


/**
 * -XX:BiasedLockingStartupDelay=0 来取消延时加载偏向锁。
 */

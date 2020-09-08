package com.xmm.concurrent;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class MyAtomicInteger {
    static ExecutorService pool;
    static {
        pool = Executors.newFixedThreadPool(12);
    }

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<Integer.MAX_VALUE;i++){
            s.append("");

        }
        log.info("endTime:{}",(System.currentTimeMillis() - startTime));
        List<Future> futures = Lists.newArrayList();
        for(int i = 0;i<12;i++){

            Future future = pool.submit(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0;i<Integer.MAX_VALUE;i++){
                        s.append("");

                    }
                }
            });
            futures.add(future);
        }
       long startTime2 = System.currentTimeMillis();
        for(Future future : futures){
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        log.info("Thread: "+Thread.currentThread().getName()+"my get end: "+(System.currentTimeMillis() - startTime2) + "");
        pool.shutdown();
    }

}

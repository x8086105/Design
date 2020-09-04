package com.xmm.concurrent.design.twoPhase;

import com.xmm.concurrent.ThreadTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoPhase {

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination threadTest = new TwoPhaseTermination();
        threadTest.start();
        Thread.sleep(3500);
        threadTest.stop();
    }

    static class TwoPhaseTermination{
        private Thread monitor;
        /**
         * 开启一个任务线程
         */
        public void start(){
            monitor = new Thread(() -> {
                Thread thread = Thread.currentThread();
                while (true){
                    if(thread.isInterrupted()){
                        log.info("料理后事");
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                        log.info("执行监控记录");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        thread.interrupt();
                    }

                }
            });
            monitor.start();
        }

        public void stop(){
            monitor.interrupt();
        }
    }
}

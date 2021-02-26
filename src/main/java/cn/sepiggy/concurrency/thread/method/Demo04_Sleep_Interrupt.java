package cn.sepiggy.concurrency.thread.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Demo04_Sleep_Interrupt")
public class Demo04_Sleep_Interrupt {

    public static void main(String[] args) throws InterruptedException {

        final Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("enter sleep...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("wake up...");
                    e.printStackTrace();
                }
            }
        };

        t1.start();

        Thread.sleep(1000);
        log.debug("interrupt...");
        // 打断正在睡眠中的t1线程
        t1.interrupt();
    }
}

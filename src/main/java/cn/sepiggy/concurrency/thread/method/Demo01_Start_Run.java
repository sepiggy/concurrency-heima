package cn.sepiggy.concurrency.thread.method;

import lombok.extern.slf4j.Slf4j;

/**
 * 区别Run()方法和Start()方法
 */
@Slf4j(topic = "c.Demo01_Start_Run")
public class Demo01_Start_Run {

    public static void main(String[] args) {
        final Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("running...");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

//        t1.run();
        t1.start();
        log.debug("do other things...");
    }
}

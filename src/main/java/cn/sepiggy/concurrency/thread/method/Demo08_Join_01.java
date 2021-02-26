package cn.sepiggy.concurrency.thread.method;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Thread#join 等待调用join方法的线程运行结束
 */
@Slf4j(topic = "c.Demo08_Join_01")
public class Demo08_Join_01 {

    static int r = 0;

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            log.debug("开始");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            r = 10;
        }, "t1");
        t1.start();
        try {
            // 等待t1线程运行结束
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("结果为:{}", r);
        log.debug("结束");
    }
}

package cn.sepiggy.concurrency.thread.method;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Demo10_Join_03")
public class Demo10_Join_03 {

    static int r1 = 0;
    static int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    private static void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        }, "t1");

        long start = System.currentTimeMillis();
        t1.start();

        log.debug("join begin");
        // 主线程等待t1线程1.5秒
        // 线程执行结束会导致join结束
        t1.join(3000);
        long end = System.currentTimeMillis();
        log.debug("r1: {}, r2: {}, cost: {}", r1, r2, end - start);
    }
}

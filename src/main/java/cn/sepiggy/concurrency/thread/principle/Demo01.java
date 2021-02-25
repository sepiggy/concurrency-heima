package cn.sepiggy.concurrency.thread.principle;

import lombok.extern.slf4j.Slf4j;

/**
 * 演示多个线程并发交替执行
 */
@Slf4j(topic = "c.TestMultiThread")
public class Demo01 {

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                log.debug("running");
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                log.debug("running");
            }
        }, "t2").start();
    }
}

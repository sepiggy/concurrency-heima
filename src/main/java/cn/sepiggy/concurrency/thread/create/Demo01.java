/**
 * 第一种创建线程的方法
 * 覆盖Thread类的run()方法
 */
package cn.sepiggy.concurrency.thread.create;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Demo01")
public class Demo01 {

    public static void main(String[] args) {

        // 创建线程对象
        Thread t = new Thread() {
            @Override
            public void run() {
                // 要执行的任务
                log.debug("running");
            }
        };

        // 创建线程的时候最好给线程一个名字
        t.setName("t1");

        // 启动线程
        t.start();

        log.debug("running");
    }
}

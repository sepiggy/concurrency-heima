/**
 * 第二种创建线程的方法
 * 把[线程]和[任务]（要执行的代码）分开
 * Thread代表线程
 * Runnable代表可运行的任务(线程要执行的代码）
 */
package cn.sepiggy.concurrency.thread.create;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Demo02")
public class Demo02 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 要执行的任务
                log.debug("running");
            }
        };

        // 创建线程对象
        // 第二个参数可以给线程起个名字
        Thread t = new Thread(runnable, "t2");

        // 启动线程
        t.start();
    }
}

/**
 * 第三种创建线程的方法
 * FutureTask能够接收Callable类型的参数，用来处理有返回结果的情况
 */
package cn.sepiggy.concurrency.thread.create;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.Demo03")
public class Demo03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建任务对象
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("running...");
                Thread.sleep(1000);
                return 100;
            }
        });

        // 第一个参数是任务对象，第二个参数是线程名字 [推荐]
        Thread t = new Thread(task, "t3");

        t.start();

        // 主线程阻塞，同步等待task执行完毕的结果
        log.debug("{}", task.get());
    }
}

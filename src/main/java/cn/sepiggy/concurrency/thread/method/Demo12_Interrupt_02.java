package cn.sepiggy.concurrency.thread.method;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 打断正常运行的线程
 * 不会清空打断标记
 * Thread#interrupt方法只是通知该线程有线程要打断你
 * 至于对此做出何种响应是由被打断线程自己决定的
 */
@Slf4j(topic = "c.Demo12_Interrupt_02")
public class Demo12_Interrupt_02 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                final boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.debug("被打断了，退出循环");
                    break;
                }
            }
        }, "t1");

        t1.start();
        TimeUnit.SECONDS.sleep(1);
        log.debug("interrupt");
        t1.interrupt();
        log.debug("打断标记:{}", t1.isInterrupted());
    }
}

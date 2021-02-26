package cn.sepiggy.concurrency.thread.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Demo13_Two_Phase_Termination")
public class Demo13_Two_Phase_Termination {

    public static void main(String[] args) {

    }
}

@Slf4j(topic = "c.TwoPhaseTermination")
class TwoPhaseTermination {

    private Thread monitor;

    // 启动监控线程
    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                final Thread thread = Thread.currentThread();
                if (thread.isInterrupted()) {
                    log.debug("料理后事");

                }
            }
        }, "monitor");

        monitor.start();
    }

    // 停止监控线程
    public void stop() {
        monitor.interrupt();
    }
}

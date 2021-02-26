package cn.sepiggy.concurrency.thread.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Demo03_Sleep_State")
public class Demo03_Sleep_State {

    public static void main(String[] args) {

        final Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        log.debug("t1 state: {}", t1.getState());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("t1 state: {}", t1.getState());
    }
}

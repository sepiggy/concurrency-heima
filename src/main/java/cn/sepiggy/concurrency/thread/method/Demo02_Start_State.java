package cn.sepiggy.concurrency.thread.method;

import lombok.extern.slf4j.Slf4j;

/**
 * Start调用之后的状态
 */
@Slf4j(topic = "c.Demo02_Start_State")
public class Demo02_Start_State {

    public static void main(String[] args) {

        final Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("running...");
            }
        };

        System.out.println(t1.getState());

        t1.start();
        // 不能多次调用start()
//        t1.start();

        System.out.println(t1.getState());
    }
}

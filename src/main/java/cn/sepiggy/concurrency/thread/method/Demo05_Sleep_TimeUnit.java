package cn.sepiggy.concurrency.thread.method;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 可以使用TimeUnit类代替Thread#sleep方法获取更好的可读性
 */
@Slf4j(topic = "c.Demo05_Sleep_TimeUnit")
public class Demo05_Sleep_TimeUnit {

    public static void main(String[] args) throws InterruptedException {

        log.debug("enter");
        TimeUnit.SECONDS.sleep(1);
        log.debug("end");
    }
}

package cn.sepiggy.concurrency.thread.method;

import java.util.concurrent.TimeUnit;

/**
 * sleep应用
 * 在没有利用cpu来计算时，不要让while(true)空转浪费cpu
 * 这时可以使用yield或sleep来让出cpu的使用权给其他程序
 */
public class Demo07_While_True_Sleep {

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

    }
}

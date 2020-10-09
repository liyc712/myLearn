package com.liyc.common.utill.test;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author lyc
 * @Date 2020-9-29 14:11
 * @ClassName MainTest
 * @Description TODO
 */
public class MainTest {

    /**
     * 1.创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小
     * 2.线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程<br>
     * 3.因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字，和线程名称<br>
     */
    @Test
    public void testThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            fixedThreadPool.execute(() -> {
                System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        fixedThreadPool.shutdown();
    }

    @Test
    public void test() {
        String s = "0.00";
        System.out.println(Integer.valueOf(s));
    }
}

package com.liyc.concurrency.threadcoreknowledge.stopthreads;

/**
 * 描述： 如果在执行过程中，每次循环都会调用sleep或wait等方法，那么不需要每次迭代都检查是否已中断
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {//在循环外卖try catch可以捕获异常，并中断异常
                while (num <= 10000) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
    /**
     * 如果在执行过程中，每次循环都会调用sleep或wait等方法，那么不需要每次迭代都检查是否已中断
     *
     * 输出结果:
     * 0是100的倍数
     * 100是100的倍数
     * java.lang.InterruptedException: sleep interrupted
     * 	at java.lang.Thread.sleep(Native Method)
     * 	at com.liyc.concurrency.threadcoreknowledge.stopthreads.RightWayStopThreadWithSleepEveryLoop.lambda$main$0(RightWayStopThreadWithSleepEveryLoop.java:16)
     * 	at java.lang.Thread.run(Thread.java:748)
     */
}

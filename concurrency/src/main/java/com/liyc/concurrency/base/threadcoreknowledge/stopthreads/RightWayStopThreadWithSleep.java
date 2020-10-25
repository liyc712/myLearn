package com.liyc.concurrency.base.threadcoreknowledge.stopthreads;

/**
 * 描述：     带有sleep的中断线程的写法
 */
public class RightWayStopThreadWithSleep {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 3000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {

                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    //当捕获到了InterruptedException，系统会清空之前设置的interrupt中断标识
                    // 此处在重新设置一次，以便于在后续的执行中，依然能够检查到刚才发生了中断
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }

        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}

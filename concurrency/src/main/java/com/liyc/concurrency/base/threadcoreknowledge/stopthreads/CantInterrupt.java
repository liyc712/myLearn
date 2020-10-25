package com.liyc.concurrency.base.threadcoreknowledge.stopthreads;

/**
 * 描述：     如果while里面放try/catch，会导致中断失效
 */
public class CantInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
    /**
     * 此时虽然调用了thread.interrupt();方法，但是由于线程的状态存在阻塞，
     * 所以会抛出java.lang.InterruptedException: sleep interrupted异常
     * 如果在循环里面放try/catch，会导致中断失效,即使捕获了异常也不会停止线程
     *
     * 输出结果如下
     *
     * 0是100的倍数
     * 100是100的倍数
     * 200是100的倍数
     * 300是100的倍数
     * 400是100的倍数
     * java.lang.InterruptedException: sleep interrupted
     * 	at java.lang.Thread.sleep(Native Method)
     * 	at com.liyc.concurrency.base.threadcoreknowledge.stopthreads.CantInterrupt.lambda$main$0(CantInterrupt.java:17)
     * 	at java.lang.Thread.run(Thread.java:748)
     * 500是100的倍数
     * ...
     *
     *
     */
}

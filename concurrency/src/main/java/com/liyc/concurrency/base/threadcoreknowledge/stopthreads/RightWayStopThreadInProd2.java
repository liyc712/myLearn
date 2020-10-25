package com.liyc.concurrency.base.threadcoreknowledge.stopthreads;

/**
 * 描述：最佳实践2：在catch子语句中调用Thread.currentThread().interrupt()来恢复设置中断状态，以便于在后续的执行中，依然能够检查到刚才发生了中断
 * 回到刚才RightWayStopThreadInProd补上中断，让它跳出
 */
public class RightWayStopThreadInProd2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted，程序运行结束");
                break;
            }
            reInterrupt();
        }
    }

    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //当捕获到了InterruptedException，系统会清空之前设置的interrupt中断标识
            // 此处在重新设置一次，以便于在后续的执行中，依然能够检查到刚才发生了中断
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
    /**
     *描述：最佳实践2：在catch子语句中调用Thread.currentThread().interrupt()来恢复设置中断状态，以便于在后续的执行中，依然能够检查到刚才发生了中断
     * 回到刚才RightWayStopThreadInProd补上中断，让它跳出
     *
     * java.lang.InterruptedException: sleep interrupted
     * 	at java.lang.Thread.sleep(Native Method)
     * 	at com.liyc.concurrency.base.threadcoreknowledge.stopthreads.RightWayStopThreadInProd2.reInterrupt(RightWayStopThreadInProd2.java:22)
     * 	at com.liyc.concurrency.base.threadcoreknowledge.stopthreads.RightWayStopThreadInProd2.run(RightWayStopThreadInProd2.java:16)
     * 	at java.lang.Thread.run(Thread.java:748)
     * Interrupted，程序运行结束
     *
     */
}

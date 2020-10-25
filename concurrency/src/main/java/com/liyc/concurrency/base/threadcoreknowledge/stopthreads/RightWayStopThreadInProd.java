package com.liyc.concurrency.base.threadcoreknowledge.stopthreads;


/**
 * 描述：最佳实践1：catch了InterruptedExcetion之后的优先选择：在方法签名中抛出异常 那么在run()就会强制try/catch
 */
public class RightWayStopThreadInProd implements Runnable {

    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                // 在InterruptedException异常中重新设置中断标识
                Thread.currentThread().interrupt();
                //保存日志、停止程序
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
            Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    /**
     *
     *最佳实践1：catch了InterruptedExcetion之后的优先选择：在方法签名中抛出异常 那么在run()就会强制try/catch
     *
     *输出结果
     * go
     * 保存日志
     * java.lang.InterruptedException: sleep interrupted
     * 	at java.lang.Thread.sleep(Native Method)
     * 	at com.liyc.concurrency.base.threadcoreknowledge.stopthreads.RightWayStopThreadInProd.throwInMethod(RightWayStopThreadInProd.java:26)
     * 	at com.liyc.concurrency.base.threadcoreknowledge.stopthreads.RightWayStopThreadInProd.run(RightWayStopThreadInProd.java:14)
     * 	at java.lang.Thread.run(Thread.java:748)
     *
     */
}

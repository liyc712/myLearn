package com.liyc.concurrency.threadcoreknowledge.stopthreads;

/**
 * 描述：注意Thread.interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象
 */
public class RightWayInterrupted {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // 启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        // 1.获取中断标志
        System.out.println("获取中断标志 threadOne.isInterrupted(): " + threadOne.isInterrupted());
        // 2.获取中断标志并重置
        System.out.println("获取中断标志并重置 threadOne.interrupted(): " + threadOne.interrupted());
        // 3.获取中断标志并重直
        System.out.println("获取中断标志并重直 Thread.interrupted(): " + Thread.interrupted());
        // 4.获取中断标志
        System.out.println("获取中断标志 threadOne.isInterrupted(): " + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("Main thread is over.");
    }

    /**
     *注意Thread.interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象的实例
     *
     *
     * 输出结果：
     *
     * 获取中断标志 threadOne.isInterrupted(): true
     * 获取中断标志并重置 threadOne.interrupted(): false
     * 获取中断标志并重直 Thread.interrupted(): false
     * 获取中断标志 threadOne.isInterrupted(): true
     *
     * 结果分析
     * 由于Thread.interrupted()方法的目标对象是“当前线程”，
     * 所以步骤2，和步骤3虽然调用了Thread.interrupted()但是他的的目标是当前线程，
     * 即使使用了threadOne的实例对象也并不会改变线程threadOne的中断标识
     *
     */
}

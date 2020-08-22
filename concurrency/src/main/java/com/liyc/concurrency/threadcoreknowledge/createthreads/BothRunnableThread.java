package com.liyc.concurrency.threadcoreknowledge.createthreads;

/**
 * 描述：     同时使用Runnable和Thread两种实现线程的方式---->最终是启动运行Thread子类重写的run方法
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":我来自Runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":我来自Thread");
            }
        }.start();
    }
}

package com.liyc.concurrency.base.threadcoreknowledge.uncaughtexception;

/**
 * 描述：使用刚才自己写的UncaughtExceptionHandler
 */
public class UseOwnUncaughtExceptionHandler implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));

        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-4").start();
    }


    @Override
    public void run() {
        throw new RuntimeException();
    }

    /**
     * 使用刚才自己写的UncaughtExceptionHandler
     *
     * 输出结果:
     *
     * 警告: 线程异常，终止啦MyThread-1
     * 捕获器1捕获了异常MyThread-1异常
     * 八月 29, 2020 9:19:09 上午 com.liyc.concurrency.base.threadcoreknowledge.uncaughtexception.MyUncaughtExceptionHandler uncaughtException
     * 警告: 线程异常，终止啦MyThread-2
     * 捕获器1捕获了异常MyThread-2异常
     * 捕获器1捕获了异常MyThread-3异常八月 29, 2020 9:19:10 上午 com.liyc.concurrency.base.threadcoreknowledge.uncaughtexception.MyUncaughtExceptionHandler uncaughtException
     * 警告: 线程异常，终止啦MyThread-3
     *
     * 八月 29, 2020 9:19:10 上午 com.liyc.concurrency.base.threadcoreknowledge.uncaughtexception.MyUncaughtExceptionHandler uncaughtException
     * 警告: 线程异常，终止啦MyThread-4
     * 捕获器1捕获了异常MyThread-4异常
     *
     */
}

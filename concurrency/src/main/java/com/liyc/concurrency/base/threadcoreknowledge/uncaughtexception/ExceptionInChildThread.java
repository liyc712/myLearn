package com.liyc.concurrency.base.threadcoreknowledge.uncaughtexception;

/**
 * 描述：当子线程抛出异常，主线程无法感知和捕获子线程的异常
 */
public class ExceptionInChildThread implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ExceptionInChildThread());
        thread.start();
        thread.join();
        System.out.println("主线程执行完毕...");
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
    /**
     * 当子线程抛出异常，主线程无法感知和捕获子线程的异常
     *
     * 运行结果:
     * Exception in thread "Thread-0" java.lang.RuntimeException
     * 	at com.liyc.concurrency.base.threadcoreknowledge.uncaughtexception.ExceptionInChildThread.run(ExceptionInChildThread.java:17)
     * 	at java.lang.Thread.run(Thread.java:748)
     * 主线程执行完毕...
     *
     */
}

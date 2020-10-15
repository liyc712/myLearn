package com.liyc.common.test.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一组线程会互相等待，直到所有线程都到达一个同步点。这个就非常有意思了，
 * 就像一群人被困到了一个栅栏前面，只有等最后一个人到达之后，他们才可以合力把栅栏（屏障）突破。
 */
public class BarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);  //①
        Runner runner1 = new Runner(barrier, "张三");
        Runner runner2 = new Runner(barrier, "李四");
        Runner runner3 = new Runner(barrier, "王五");

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(runner1);
        service.execute(runner2);
        service.execute(runner3);

        service.shutdown();

    }

}


class Runner implements Runnable{

    private CyclicBarrier barrier;
    private String name;

    public Runner(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            //模拟准备耗时
            Thread.sleep(new Random().nextInt(5000));
            System.out.println(name + ":准备OK");
            barrier.await();
            System.out.println(name +": 开跑");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}
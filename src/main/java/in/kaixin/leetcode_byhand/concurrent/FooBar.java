package in.kaixin.leetcode_byhand.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    //    https://leetcode-cn.com/problems/print-foobar-alternately/
    private int n;
    ReentrantLock lock = new ReentrantLock(true);
    Semaphore fooSemaphore = new Semaphore(1);
    Semaphore barSemaphore = new Semaphore(0);
    volatile int cnt = 0;


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            printBar.run();
            fooSemaphore.release();
        }
    }

//    public void foo(Runnable printFoo) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            while (true) {
//                if (cnt % 2 != 0) {
//                    continue;
//                }
//                lock.lock();
//                printFoo.run();
//                cnt++;
//                lock.unlock();
//                break;
//            }
//
//        }
//        countDownLatch.countDown();
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            while (true) {
//                if (cnt % 2 != 1) {
//                    continue;
//                }
//                lock.lock();
//                printBar.run();
//                cnt++;
//                lock.unlock();
//                break;
//            }
//        }
//        countDownLatch.countDown();
//    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        FooBar fooBar = new FooBar(10);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        fooBar.countDownLatch.await();
        executorService.shutdown();


    }

    CountDownLatch countDownLatch = new CountDownLatch(2);
}

package in.kaixin.leetcode_byhand.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {
    //    https://leetcode-cn.com/problems/print-in-order/


    public PrintInOrder() {

    }

    //    volatile int i = 0;
//    ReentrantLock lock = new ReentrantLock(true);
    volatile CountDownLatch countDownLatch = new CountDownLatch(3);
//
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        while (true) {
//            if (lock.tryLock(0, TimeUnit.SECONDS)) {
//                if (i % 3 == 0) {
//                    printFirst.run();
//                    i++;
//                    lock.unlock();
////                    countDownLatch.countDown();
//                    break;
//                }
//                lock.unlock();
//            }
//        }
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        while (true) {
//            if (lock.tryLock(0, TimeUnit.SECONDS)) {
//                if (i % 3 == 1) {
//                    printSecond.run();
//                    i++;
//                    lock.unlock();
////                    countDownLatch.countDown();
//                    break;
//                }
//                lock.unlock();
//            }
//        }
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//
//        // printThird.run() outputs "third". Do not change or remove this line.
//        while (true) {
//            if (lock.tryLock(0, TimeUnit.SECONDS)) {
//                if (i % 3 == 2) {
//                    printThird.run();
//                    i++;
//                    lock.unlock();
////                    countDownLatch.countDown();
//                    break;
//                }
//                lock.unlock();
//            }
//        }
//    }

    public Object monitor = new Object();
    volatile int i = 0;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while (true) {
            synchronized (monitor) {
                if (i % 3 == 0) {
                    printFirst.run();
                    i++;
                    monitor.notifyAll();
                    countDownLatch.countDown();
                    break;
                }
                monitor.notifyAll();

            }
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (true) {
            synchronized (monitor) {
                if (i % 3 == 1) {
                    printSecond.run();
                    i++;
                    monitor.notifyAll();
                    countDownLatch.countDown();
                    break;
                }
                monitor.notifyAll();

            }

        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (true) {
            synchronized (monitor) {
                if (i % 3 == 2) {
                    printThird.run();
                    i++;
                    monitor.notifyAll();
                    countDownLatch.countDown();
                    break;
                }
                monitor.notifyAll();

            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        PrintInOrder in = new PrintInOrder();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    in.third(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("3");
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
                    in.second(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("2");
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
                    in.first(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("1");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        in.third(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("3");
//            }
//        });
//        in.second(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("2");
//            }
//        });
//        in.first(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("1");
//            }
//        });
        in.countDownLatch.await();
        executorService.shutdown();

        System.out.println("Finished");
    }


}

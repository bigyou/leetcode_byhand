package in.kaixin.leetcode_byhand.concurrent;

import java.util.concurrent.Semaphore;

public class ZeroEvenOdd {
//    https://leetcode-cn.com/problems/print-zero-even-odd/

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    Semaphore zero = new Semaphore(1);
    Semaphore even = new Semaphore(0);
    Semaphore odd = new Semaphore(0);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if ((i + 1) % 2 == 0) {
                even.release();
            } else {
                odd.release();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {//输出奇数
//        偶数
        for (int i = 1; 2 * i - 1 <= n; i++) {
            odd.acquire();
            printNumber.accept(2 * i - 1);
            zero.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {//输出偶数
//        奇数
        for (int i = 1; 2 * i <= n; i++) {
            even.acquire();
            printNumber.accept(2 * i);
            zero.release();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(new IntConsumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(new IntConsumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(new IntConsumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

class IntConsumer {
    public void accept(int x) {
        System.out.println(x);
    }
}


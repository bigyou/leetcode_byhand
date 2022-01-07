package in.kaixin.leetcode_byhand.concurrent;

import java.util.concurrent.Semaphore;

public class FizzBuzz {
    //    https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
    private int n;
    Semaphore num = new Semaphore(1);
    Semaphore fuzz = new Semaphore(0);
    Semaphore buzz = new Semaphore(0);
    Semaphore fuzzbuzz = new Semaphore(0);


    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 || i % 5 == 0) {
                continue;
            }

            fuzz.acquire();
            printFizz.run();
            num.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 5 != 0 || i % 3 == 0) {
                continue;
            }
            buzz.acquire();
            printBuzz.run();
            num.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 15 != 0) {
                continue;
            }
            fuzzbuzz.acquire();
            printFizzBuzz.run();
            num.release();

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            num.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                fuzzbuzz.release();
            } else if (i % 3 == 0) {
                fuzz.release();
            } else if (i % 5 == 0) {
                buzz.release();
            } else {
                printNumber.accept(i);
                num.release();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(15);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.buzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("buzz ");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("fizz ");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizzbuzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("fizzbuzz ");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.number(new IntConsumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

//class IntConsumer {
//    public void accept(int x) {
//        System.out.print(x + " ");
//    }
//}

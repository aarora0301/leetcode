package main.java.Concurrency;

import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    private int currentNum = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (currentNum <= n) {
            if (currentNum % 3 != 0 || currentNum % 5 == 0) {
                wait();
            } else {
                printFizz.run();
                currentNum++;
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (currentNum <= n) {
            if (currentNum % 5 != 0 || currentNum % 3 == 0) {
                wait();
            } else {
                printBuzz.run();
                currentNum++;
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (currentNum <= n) {
            if (currentNum % 15 != 0) {
                wait();
            } else {
                printFizzBuzz.run();
                currentNum++;
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (currentNum <= n) {
            if (currentNum % 3 == 0 || currentNum % 5 == 0) {
                wait();
            } else {
                printNumber.accept(currentNum);
                currentNum++;
                notifyAll();
            }
        }
    }
}


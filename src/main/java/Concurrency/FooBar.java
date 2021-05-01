package main.java.Concurrency;

public class FooBar {

    private int n;
    private volatile boolean flag = false;


    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while (flag) {
                wait();
            }

            printFoo.run();
            flag = !flag;
            notifyAll();

            // printFoo.run() outputs "foo". Do not change or remove this line.

        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while (!flag) {
                wait();
            }
            printBar.run();
            flag = !flag;
            notifyAll();

            // printBar.run() outputs "bar". Do not change or remove this line.
            // printBar.run();
        }

    }
}

package main.java;

public class MyRunnableMain {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread = new Thread(myRunnable, "aarshi");

        thread.start();

        System.out.println("chec1 "+ Thread.currentThread().getName());

        try {
            Thread.sleep(60L * 1000L);
            System.out.println("chec2 "+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myRunnable.doStop();
    }
}

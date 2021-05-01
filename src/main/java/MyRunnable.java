package main.java;

public class MyRunnable implements Runnable {

    private boolean doStop = false;

    public void doStop() {
        this.doStop = true;
    }

    private  boolean keepRunning() {
        return this.doStop == false;
    }

    @Override
    public void run() {
        while(keepRunning()) {
            // keep doing what this thread should do.
           // System.out.println("Running");

            try {
                System.out.println("inside runnable "+ Thread.currentThread().getName());
                Thread.sleep(20L*1000L);
                System.out.println("inside runnable after sleep"+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

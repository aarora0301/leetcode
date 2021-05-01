package main.java.Concurrency;

public class DiningPhilosophers {


    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public synchronized  void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

    }
}

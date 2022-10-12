package Task4;

import Task4.Multithreading.RunnableCalc;
import Task4.Multithreading.CalcThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task4 {
    public static void main(String[] args) {
        CalcThread thread1 = new CalcThread(3,  400, "1 Thread");
        CalcThread thread2 = new CalcThread(5, 40, "2 Thread");
        Runnable runnable1 = new RunnableCalc(6, 500, "1 Runnable");
        Runnable runnable2 = new RunnableCalc(9, 2000, "2 Runnable");

        thread1.start();
        thread2.start();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(runnable1);
        executorService.execute(runnable2);

        try {
            Thread.sleep(2000);
        } catch (final InterruptedException e) {

        }
        thread1.stopThread();
        thread2.stopThread();
        executorService.shutdown();
    }
}
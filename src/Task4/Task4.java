package Task4;

import Task4.Multithreading.RunnableCalc;
import Task4.Multithreading.CalcThread;

public class Task4 {
    public static void main(String[] args) {
        CalcThread thread1 = new CalcThread(3,  400, "1 Thread");
        CalcThread thread2 = new CalcThread(5, 40, "2 Thread");
        RunnableCalc runnable1 = new RunnableCalc(6, 500, "1 Runnable");
        RunnableCalc runnable2 = new RunnableCalc(9, 5000, "2 Runnable");

        Thread threadRunnable1 = new Thread(runnable1);
        Thread threadRunnable2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        threadRunnable1.start();
        threadRunnable2.start();

        try {
            Thread.sleep(2000);
        } catch (final InterruptedException e) {

        }
        thread1.stopThread();
        thread2.stopThread();
        runnable1.stopThread();
        runnable2.stopThread();
    }
}
package Task4.Multithreading;

public class CalcThread extends Thread{
    private boolean shouldBeStopped = false;
    int iterations = 10;
    int milliseconds = 100;
    String threadName;

    public CalcThread(int iterations, int milliseconds, String threadName) {
        this.iterations = iterations;
        this.milliseconds = milliseconds;
        this.threadName = threadName;
    }

    public CalcThread(String threadName) {
        this.threadName = threadName;
    }

    public void stopThread() {
        this.shouldBeStopped = true;
    }


    public void run() {
        System.out.printf("Thread [" + threadName + "]. started calculation \n");
        for (int i = 0; i < 10; i++)
        {
            if (!isInterrupted() && !shouldBeStopped)
            {
                Calculations.calculate(i + 1, milliseconds, threadName);
            }
        }
        System.out.printf("Thread [" + threadName + "]. finished calculation \n");
    }
}

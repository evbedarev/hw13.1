package ru.sberbank.homework.bedarev;

import ru.sberbank.homework.common.tasks.CalculationTask;
import ru.sberbank.homework.common.tasks.SleepyTask;
import ru.sberbank.homework.common.tasks.StringsTask;

import java.util.ArrayList;
import java.util.List;

public class ParallelThreads {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        long millis = System.currentTimeMillis();
        threads.add(new Thread(new StringsTask()));
        threads.add(new Thread(new CalculationTask()));
        threads.add(new Thread(new SleepyTask()));

//        parallelRun(threads);
        gradualRun(threads);

        System.out.println("All tasks completed! Time: " + (System.currentTimeMillis() - millis));
    }

    private static void parallelRun (List<Thread> threads) {
        try {
            for (Thread thread:threads) {
                thread.start();
            }
            for (Thread thread:threads) {
                thread.join();
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    private static void gradualRun(List<Thread> threads) {
        try {
            for (Thread thread:threads) {
                thread.start();
                thread.join();
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}

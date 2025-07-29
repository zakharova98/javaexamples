package org.example.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDemo {

    public static void main(String[] args) {
        // создаем экземпляр ExecutorService с 3 потоками
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        System.out.println("THREAD[" + Thread.currentThread().getName() + "] Start");

        // создаем список с 6 задачами для примера
        List<Callable<String>> callableTasks = getCallables();
        List<Future<String>> futures = new ArrayList<>();
        try {
            // invokeAll() назначает коллекцию задач ExecutorService
            // вызывая запуск каждой из них, и возвращает результат
            // выполнения всех задач в виде списка объектов типа Future
            futures = executorService.invokeAll(callableTasks); //
        } catch (InterruptedException e) {
            System.out.println("Some error occurred: " + e.getMessage());
        }

        System.out.println();
        
        String result;
        if (!futures.isEmpty()) {
            for (Future<String> future : futures) {
                try {
                    // get() возвращает фактический результат выполнения задачи Callable
                    result = future.get();
                    System.out.println("Result: " + result);
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Some error occurred: " + e.getMessage());
                }
            }
        }

        // shutdown() заставит ExecutorService прекратить приём новых задач и завершить работу
        // после того, как все запущенные потоки завершат свою текущую работу
        executorService.shutdown();
        System.out.println("THREAD[" + Thread.currentThread().getName() + "] Finish");
    }

    private static List<Callable<String>> getCallables() {
        Callable<String> callableTask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("THREAD [" + threadName + "]");
            TimeUnit.MILLISECONDS.sleep(300);

            return threadName;
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            callableTasks.add(callableTask);
        }
        return callableTasks;
    }
}

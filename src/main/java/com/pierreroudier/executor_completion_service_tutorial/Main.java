package com.pierreroudier.executor_completion_service_tutorial;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        try {
            ExecutorService es = Executors.newFixedThreadPool(THREAD_COUNT);
            ExecutorCompletionService<TaskResult> ecs = new ExecutorCompletionService<TaskResult>(es);

            new Thread(new TaskProducer(ecs, 2f)).start();
            new Thread(new ResultConsumer(ecs)).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

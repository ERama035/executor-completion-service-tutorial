package com.pierreroudier.executor_completion_service_tutorial;

import java.util.concurrent.*;

public class ResultConsumptionBoundExecutor extends ThreadPoolExecutor {
    private static final int WAIT_TIME = 500;

    private final BlockingQueue<Future<TaskResult>> resultQueue;
    private final int queueMaxSize;

    public ResultConsumptionBoundExecutor(int threadPoolSize, BlockingQueue<Future<TaskResult>> resultQueue, int queueMaxSize) {
        super(threadPoolSize, threadPoolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        this.resultQueue = resultQueue;
        this.queueMaxSize = queueMaxSize;
    }

    protected void beforeExecute(Thread t, Runnable r) {
        try {
            while (resultQueue.size() > queueMaxSize) {
                System.out.println("Waiting for result queue to be consumed");
                Thread.sleep(WAIT_TIME);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

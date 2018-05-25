package com.pierreroudier.executor_completion_service_tutorial;

import java.util.concurrent.CompletionService;

public class TaskProducer implements Runnable {

    private final int productionPeriodMs;
    private final CompletionService<TaskResult> completionService;
    private long counter = 0;

    public TaskProducer(CompletionService<TaskResult> completionService, float productionFrequencyHz) {
        this.productionPeriodMs = (int) (1000 * (1.0d / (double) productionFrequencyHz));
        this.completionService = completionService;
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                TaskParameter param = new TaskParameter("Data set #" + nextCounter(), 50000);
                Task computation = new Task(param);
                System.out.println(param.getLabel() + ": producing task");
                completionService.submit(computation);
                Thread.sleep(productionPeriodMs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private long nextCounter() {
        return ++counter;
    }
}

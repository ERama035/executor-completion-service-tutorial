package com.pierreroudier.executor_completion_service_tutorial;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Future;

public class ResultConsumer implements Runnable {

    private final CompletionService<TaskResult> completionService;

    public ResultConsumer(CompletionService<TaskResult> completionService) {
        this.completionService = completionService;
    }

    public void run() {
        try {
            for (; ; ) {
                Future<TaskResult> future = completionService.take();
                System.out.println(future.get().getParam().getLabel() + ": result consummed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

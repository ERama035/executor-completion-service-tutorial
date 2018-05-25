package com.pierreroudier.executor_completion_service_tutorial;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

public class Task implements Callable<TaskResult> {

    private final TaskParameter params;

    public Task(TaskParameter params) {
        super();
        this.params = params;
    }

    @Override
    public TaskResult call() throws Exception {
        System.out.println(params.getLabel() + ": computation beginning");

        long n = params.getNumber();
        BigDecimal fact = BigDecimal.ONE;
        for (long l = 1; l <= n; l++) {
            fact = fact.multiply(new BigDecimal(l));
        }

        System.out.println(params.getLabel() + ": computation end");
        return new TaskResult(params, fact);
    }
}

package com.pierreroudier.executor_completion_service_tutorial;

import java.math.BigDecimal;

public class TaskResult {
    private final TaskParameter param;
    private final BigDecimal result;

    public TaskResult(TaskParameter param, BigDecimal result) {
        this.param = param;
        this.result = result;
    }

    public TaskParameter getParam() {
        return param;
    }

    public BigDecimal getResult() {
        return result;
    }
}

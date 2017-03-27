package com.example.davidc.interactor;

import java.util.concurrent.ThreadPoolExecutor;

public interface ThreadPoolExecutorTaskSchedulerFactory {
    TaskScheduler create(final ThreadPoolExecutor threadPoolExecutor);
}

package com.davidc.interactor;

import java.util.concurrent.ThreadPoolExecutor;

abstract class ThreadPoolExecutorTaskScheduler implements TaskScheduler {
    private final ThreadPoolExecutor threadPoolExecutor;

    ThreadPoolExecutorTaskScheduler(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    @Override
    public void executeOnWorkerThread(final Task task) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                task.execute();
            }
        });
    }
}

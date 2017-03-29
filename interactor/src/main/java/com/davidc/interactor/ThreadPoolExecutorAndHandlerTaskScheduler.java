package com.davidc.interactor;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorAndHandlerTaskScheduler extends ThreadPoolExecutorTaskScheduler {
    private final Handler handler;

    public ThreadPoolExecutorAndHandlerTaskScheduler(ThreadPoolExecutor threadPoolExecutor, Looper looper) {
        super(threadPoolExecutor);
        this.handler = new Handler(looper);
    }

    @Override
    public void executeOnCallbackThread(final Task task) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                task.execute();
            }
        });
    }
}

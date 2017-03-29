package com.davidc.interactor;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorAndHandlerTaskScheduler extends ThreadPoolExecutorTaskScheduler {
    private final Handler callbackHandler;

    public ThreadPoolExecutorAndHandlerTaskScheduler(ThreadPoolExecutor threadPoolExecutor, Looper callbackLooper) {
        super(threadPoolExecutor);
        this.callbackHandler = new Handler(callbackLooper);
    }

    @Override
    public void executeOnCallbackThread(final Task task) {
        callbackHandler.post(new Runnable() {
            @Override
            public void run() {
                task.execute();
            }
        });
    }
}

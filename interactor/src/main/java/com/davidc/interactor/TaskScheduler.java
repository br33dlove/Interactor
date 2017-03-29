package com.davidc.interactor;

public interface TaskScheduler {
    void executeOnWorkerThread(final Task task);
    void executeOnCallbackThread(final Task task);
}

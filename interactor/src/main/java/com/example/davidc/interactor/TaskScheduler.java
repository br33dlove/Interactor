package com.example.davidc.interactor;

public interface TaskScheduler {
    void executeOnBoundThread(final Task task);
    void executeOnWorkerThread(final Task task);
}

package com.davidc.interactor;

public abstract class Interactor {
    private final TaskScheduler taskScheduler;

    protected Interactor(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    protected void executeOnWorkerThread(final Task task) {
        taskScheduler.executeOnWorkerThread(task);
    }

    protected void executeOnCallbackThread(final Task task) {
        taskScheduler.executeOnCallbackThread(task);
    }
}

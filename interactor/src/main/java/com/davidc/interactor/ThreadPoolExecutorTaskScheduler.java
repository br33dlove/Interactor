//Copyright 2017 David Cryer
//
//        Licensed under the Apache License, Version 2.0 (the "License");
//        you may not use this file except in compliance with the License.
//        You may obtain a copy of the License at
//
//        http://www.apache.org/licenses/LICENSE-2.0
//
//        Unless required by applicable law or agreed to in writing, software
//        distributed under the License is distributed on an "AS IS" BASIS,
//        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//        See the License for the specific language governing permissions and
//        limitations under the License.

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

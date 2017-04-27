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

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ThreadPoolExecutor;

@SuppressWarnings("unused")
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

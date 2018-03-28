package com.msww.ms.user.tasks;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
    @Async
    public Future<Boolean> doTaskFirst() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("The first takes " + (end - start) + " millis second");
        return new AsyncResult<Boolean>(true);
    }

    @Async
    public Future<Boolean> doTaskSecond() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        long end = System.currentTimeMillis();
        System.out.println("The second takes " + (end - start) + " millis second");
        return new AsyncResult<Boolean>(true);
    }

    @Async
    public Future<Boolean> doTaskThird() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("The third takes " + (end - start) + " millis second");
        return new AsyncResult<Boolean>(true);
    }

}

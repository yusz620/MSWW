package com.msww.ms.user.tasks;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "tasks")
public class DoAsyncTaskController {
    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping(value = "first")
    public String doFirstTask() throws Exception {
        long start = System.currentTimeMillis();
        Future<Boolean> firstTask = asyncTask.doTaskFirst();
        Future<Boolean> secondTask = asyncTask.doTaskSecond();
        Future<Boolean> thirdTask = asyncTask.doTaskThird();
        while (!firstTask.isDone() || !secondTask.isDone() || !thirdTask.isDone()) {
            if (firstTask.isDone() && secondTask.isDone() && thirdTask.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        String time = "All the tasks takes " + (end - start) + " millis seconds to complete";
        System.out.println("All the tasks takes " + (end - start) + " millis seconds to complete");
        return time;
    }
}

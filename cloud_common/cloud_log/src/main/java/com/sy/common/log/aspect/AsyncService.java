package com.sy.common.log.aspect;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void  saveLog(String log) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("log -------------------------------------------------------- =  " + log);
    }
}

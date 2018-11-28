package com.sakura.springboottask.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author: Sakura
 * @Description: 异步任务
 * @Date: 2018/11/27 15:13
 */
@Service
public class AsyncService {

    @Async
    public void Async() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理中。。。。");
    }
}

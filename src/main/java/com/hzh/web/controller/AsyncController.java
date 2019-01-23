package com.hzh.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

@Controller
public class AsyncController {

    @RequestMapping(value = "/listenable", produces = "text/plain; charset=UTF-8")
    public ListenableFuture<ResponseEntity<String>> listenableFuture() {

        ListenableFuture<ResponseEntity<String>> future = new AsyncRestTemplate().getForEntity(
            "https://www.baidu.com",String.class);

        return future;
    }

    @ResponseBody
    @RequestMapping(value = "/webasynctask",produces = "text/plain;charset=UTF-8")
    public WebAsyncTask<String> webAsyncTask() {

        System.out.println("WebAsyncTask处理器主线程进入");

        WebAsyncTask<String> task = new WebAsyncTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5 * 1000L);
                System.out.println("WebAsyncTask处理执行...");
                return "久等了";
            }
        });

        System.out.println("WebAsyncTask处理器主线程退出");
        task.onCompletion(new Runnable() {
            @Override
            public void run() {
                System.out.println("dddd");
            }
        });
        return task;
    }

}

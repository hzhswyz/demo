package com.hzh.asynceventListener;


import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BossListener implements AsyncListener {

    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");

    @Override
    public void onComplete(AsyncEvent event) throws IOException {

        System.out.println("在" + formatter.format(new Date()) + "工作处理完成");
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {

        System.out.println("在" + formatter.format(new Date()) + "工作处理出错，详情如下"
                + event.getThrowable().getMessage());
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {

        System.out.println("在" + formatter.format(new Date()) + "工作处理开始");
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {

        System.out.println("在" + formatter.format(new Date()) + "工作处理超时");

    }
}




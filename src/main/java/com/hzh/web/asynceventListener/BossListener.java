package com.hzh.web.asynceventListener;


import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BossListener implements AsyncListener {

    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");

    @Override
    public void onComplete(AsyncEvent event) throws IOException {

        //System.out.println("在" + formatter.format(new Date()) + "工作处理完成");
        try {
            AsyncContext asyncContext = event.getAsyncContext();
            ServletResponse response = asyncContext.getResponse();
            ServletRequest request = asyncContext.getRequest();
            PrintWriter out= response.getWriter();
            if (request.getAttribute("timeout") != null &&
                    "true".equals(request.getAttribute("timeout").toString())) {//超时
                out.println("wwwsss后台线程执行超时---【回调】");
                System.out.println("异步servlet【onComplete超时】");
            }else {//未超时
                out.println("qqqsss后台线程执行完成---【回调】");
                System.out.println("异步servlet【onComplete完成】");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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

       // System.out.println("在" + formatter.format(new Date()) + "工作处理超时");
        ServletRequest request = event.getAsyncContext().getRequest();
        request.setAttribute("timeout", "true");
        System.out.println("异步servlet【onTimeout超时】");
    }
}




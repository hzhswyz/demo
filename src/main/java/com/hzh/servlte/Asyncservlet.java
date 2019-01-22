package com.hzh.servlte;

import com.hzh.asynceventListener.BossListener;
import org.springframework.http.HttpRequest;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Asyncservlet extends HttpServlet {

    private int i = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType ("text/plain;charset=UTF-8");
        res.setHeader ("CacheControl","private");
        res. setHeader ("Pragma", "no-cache") ;

        final PrintWriter writer = res. getWriter ();
        writer.println("老板来视察工作");
        writer.flush();

        List<String> jobs = new ArrayList<>();
        for(int i=0;i<10;i++) {
            jobs.add("job" + i);
        }

        final AsyncContext ac = req.startAsync();
        ac.addListener(new BossListener());
        doWork(ac, jobs);

        writer.println("老板走了");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writer.println("主线程结束");
        writer.flush();
    }

    public void doWork(final AsyncContext ac, final List<String> jobs){

        ac.setTimeout (1*2*1000);
        ac.start (new Runnable() {
            @Override
            public void run() {
                System.out.println("开始执行");
                ServletRequest request = ac.getRequest();
                Long l = 300L;
                if(i++%2==0)
                    l=100L;
                try {
                    PrintWriter w = ac.getResponse().getWriter();
                    for (String job : jobs) {
                        System.out.println(job + "时间："+l+" 请求处理中..."+Thread.currentThread().getId()+"  "+request.getAsyncContext());
                        w.println(job + "请求处理中...");
                        Thread.sleep(l);
                        w.flush();
                    }
                    ac.complete();
                    //ac.dispatch("/DoDispatch");
                    //System.out.println("dddddd");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

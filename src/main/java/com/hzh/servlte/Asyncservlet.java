package com.hzh.servlte;

import com.hzh.asynceventListener.BossListener;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Asyncservlet extends HttpServlet {
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
        writer.flush() ;

        List<String> jobs = new ArrayList<>();
        for(int i=0;i<10;i++) {
            jobs.add("job" + i);
        }

        final AsyncContext ac = req.startAsync();
        ac.addListener(new BossListener());
        doWork(ac, jobs);

        writer.println("老板走了");
        writer.flush();
    }

    public void doWork(final AsyncContext ac, final List<String> jobs){

        ac.setTimeout (1*10*1000);
        ac.start (new Runnable() {
            @Override
            public void run() {
                try {
                    PrintWriter w = ac.getResponse().getWriter();
                    for (String job : jobs) {
                        w.println(job + "请求处理中...");
                        Thread.sleep(1 * 100L);
                        w.flush();

                    }
                    ac.complete();
                    //System.out.println("dddddd");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

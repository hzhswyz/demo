package com.hzh.demo.servlte;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SyncTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType ("text/plain;charset=UTF-8");
        res.setHeader ("CacheControl","private");
        res. setHeader ("Pragma", "no-cache") ;
        System.out.println("pppppp");
        req.getRequestDispatcher("/SyncTest2").forward(req,res);
        System.out.println("ffffff");
    }

}

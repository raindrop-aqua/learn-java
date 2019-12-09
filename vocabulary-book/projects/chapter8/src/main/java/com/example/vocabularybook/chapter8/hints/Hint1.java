package com.example.vocabularybook.chapter8.hints;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Hint1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 遷移元のページからパラメータを取得する<1>
        String word = req.getParameter("word");

        // Servlet 内で Spring Framework が管理する Beans を取得する<2>
        WebApplicationContext context
                = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

        // 遷移後のページに値を送出する<3>
        req.setAttribute("word", word);
        req.setAttribute("result", "結果を出力");

        // 処理が終わったあとのページ遷移<4>
        RequestDispatcher dispatcher = req.getRequestDispatcher("hint1.jsp");
        dispatcher.forward(req, resp);
    }
}

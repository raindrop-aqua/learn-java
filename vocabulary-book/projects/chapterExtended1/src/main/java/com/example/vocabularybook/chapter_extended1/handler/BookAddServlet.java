package com.example.vocabularybook.chapter_extended1.handler;

import com.example.vocabularybook.chapter8.dto.TranslateLogicInDTO;
import com.example.vocabularybook.chapter8.dto.TranslateLogicOutDTO;
import com.example.vocabularybook.chapter8.logic.TranslateLogic;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word1 = req.getParameter("word1");
        String word2 = req.getParameter("word2");

        if (word1 != null && word2 != null) {
            WebApplicationContext context
                    = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
            TranslateLogic logic = (TranslateLogic) context.getBean("aopBookLogic");

            TranslateLogicInDTO inDto = new TranslateLogicInDTO();
            inDto.setCommand("a " + word1 + " " + word2);
            TranslateLogicOutDTO outDto = logic.execute(inDto);
            req.setAttribute("word1", word1);
            req.setAttribute("word2", word2);
            req.setAttribute("result", outDto.getMessage());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("management.jsp");
        dispatcher.forward(req, resp);
    }
}

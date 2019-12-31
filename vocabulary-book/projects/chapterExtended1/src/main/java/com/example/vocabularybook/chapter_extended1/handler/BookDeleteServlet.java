package com.example.vocabularybook.chapter_extended1.handler;

import com.example.vocabularybook.chapter_extended1.dto.TranslateLogicInDTO;
import com.example.vocabularybook.chapter_extended1.dto.TranslateLogicOutDTO;
import com.example.vocabularybook.chapter_extended1.logic.TranslateLogic;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");

        if (word != null) {
            WebApplicationContext context
                    = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
            TranslateLogic logic = (TranslateLogic) context.getBean("aopBookLogic");

            TranslateLogicInDTO inDto = new TranslateLogicInDTO();
            inDto.setCommand("d " + word);
            TranslateLogicOutDTO outDto = logic.execute(inDto);
            req.setAttribute("word", word);
            req.setAttribute("result", outDto.getMessage());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("management.jsp");
        dispatcher.forward(req, resp);
    }
}

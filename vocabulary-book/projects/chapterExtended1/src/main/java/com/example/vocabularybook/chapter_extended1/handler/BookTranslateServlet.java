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

public class BookTranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // パラメータを取得<1>
        String word = req.getParameter("word");

        if (word != null) {
            // Spring Bean をアプリケーション・サーバーから取得する<2>
            WebApplicationContext context
                    = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
            TranslateLogic logic = (TranslateLogic) context.getBean("aopBookLogic");
            // ビジネスロジックの実行<3>
            TranslateLogicInDTO inDto = new TranslateLogicInDTO();
            inDto.setCommand("t " + word);
            TranslateLogicOutDTO outDto = logic.execute(inDto);
            // 処理結果を設定する<4>
            req.setAttribute("word", word);
            req.setAttribute("result", outDto.getMessage());
        }
        // 処理が終わったあとの遷移画面を設定する<5>
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}

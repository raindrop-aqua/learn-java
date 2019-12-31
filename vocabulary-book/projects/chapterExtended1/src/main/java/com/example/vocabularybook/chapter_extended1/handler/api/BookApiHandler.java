package com.example.vocabularybook.chapter_extended1.handler.api;


import com.example.vocabularybook.chapter_extended1.dto.TranslateLogicInDTO;
import com.example.vocabularybook.chapter_extended1.dto.TranslateLogicOutDTO;
import com.example.vocabularybook.chapter_extended1.logic.TranslateLogic;
import com.example.vocabularybook.chapter_extended1.thrift.BookApi;
import org.apache.thrift.TException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

public class BookApiHandler implements BookApi.Iface {

    private ServletContext context;

    /**
     * コンストラクタ
     *
     * @param context Spring Framework にアクセスするためのコンテキストを設定
     */
    public BookApiHandler(ServletContext context) {
        this.context = context;
    }

    @Override
    public String search(String word) throws TException {
        String message = "";

        if (!"".equals(word)) {
            WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            TranslateLogic logic = (TranslateLogic) wac.getBean("aopBookLogic");
            TranslateLogicInDTO inDTO = new TranslateLogicInDTO();
            inDTO.setCommand("t " + word);
            TranslateLogicOutDTO outDTO = logic.execute(inDTO);
            message = outDTO.getMessage();
        }
        return message;
    }

    @Override
    public String addword(String word1, String word2) throws TException {
        String message = "";

        if (!"".equals(word1) && !"".equals(word2)) {
            WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            TranslateLogic logic = (TranslateLogic) wac.getBean("aopBookLogic");
            TranslateLogicInDTO inDTO = new TranslateLogicInDTO();
            inDTO.setCommand("a " + word1 + " " + word2);
            TranslateLogicOutDTO outDTO = logic.execute(inDTO);
            message = outDTO.getMessage();
        }
        return message;
    }

    @Override
    public String deleteWord(String word) throws TException {
        String message = "";

        if (!"".equals(word)) {
            WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            TranslateLogic logic = (TranslateLogic) wac.getBean("aopBookLogic");
            TranslateLogicInDTO inDTO = new TranslateLogicInDTO();
            inDTO.setCommand("d " + word);
            TranslateLogicOutDTO outDTO = logic.execute(inDTO);
            message = outDTO.getMessage();
        }
        return message;
    }
}

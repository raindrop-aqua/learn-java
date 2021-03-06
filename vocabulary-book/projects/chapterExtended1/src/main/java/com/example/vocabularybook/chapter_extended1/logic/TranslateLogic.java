package com.example.vocabularybook.chapter_extended1.logic;

import com.example.vocabularybook.chapter_extended1.dto.TranslateLogicInDTO;
import com.example.vocabularybook.chapter_extended1.dto.TranslateLogicOutDTO;

/**
 * 翻訳ロジック
 */
public interface TranslateLogic {
    /**
     * 翻訳を行う
     *
     * @param params 翻訳パラメータ
     * @return 翻訳実行結果
     */
    TranslateLogicOutDTO execute(TranslateLogicInDTO params);
}

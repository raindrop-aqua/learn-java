package com.example.vocabularybook.chapter3.service;

import com.example.vocabularybook.chapter3.dto.TranslateServiceInDTO;
import com.example.vocabularybook.chapter3.dto.TranslateServiceOutDTO;

/**
 * 翻訳サービス
 */
public interface TranslateService {

    /**
     * 翻訳サービス
     *
     * @param params 翻訳サービスパラメータ
     * @return 翻訳サービス実行結果
     */
    TranslateServiceOutDTO execute(TranslateServiceInDTO params);
}

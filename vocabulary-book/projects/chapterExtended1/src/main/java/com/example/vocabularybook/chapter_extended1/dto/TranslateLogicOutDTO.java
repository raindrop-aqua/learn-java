package com.example.vocabularybook.chapter_extended1.dto;

/**
 * 翻訳ロジック出力
 */
public class TranslateLogicOutDTO {
    /** メッセージ */
    private String message;
    /** 終了判定 */
    private boolean terminate;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isTerminate() {
        return terminate;
    }

    public void setTerminate(boolean terminate) {
        this.terminate = terminate;
    }
}

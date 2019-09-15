package com.example.vocabularybook.chapter3.dto;

/**
 * 翻訳サービス出力
 */
public class TranslateServiceOutDTO {

    private String message;

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

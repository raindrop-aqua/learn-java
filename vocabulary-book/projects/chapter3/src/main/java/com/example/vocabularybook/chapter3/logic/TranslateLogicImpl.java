package com.example.vocabularybook.chapter3.logic;

import com.example.vocabularybook.chapter3.dataaccess.BookAccessor;
import com.example.vocabularybook.chapter3.dataaccess.BookOnMemoryImpl;
import com.example.vocabularybook.chapter3.dto.TranslateLogicInDTO;
import com.example.vocabularybook.chapter3.dto.TranslateLogicOutDTO;

/**
 * 翻訳サービス実装
 */
public class TranslateLogicImpl implements TranslateLogic {

    /** 単語帳データへのアクセス */
    private BookAccessor book = new BookOnMemoryImpl();

    @Override
    public TranslateLogicOutDTO execute(final TranslateLogicInDTO params) {
        TranslateLogicOutDTO output = new TranslateLogicOutDTO();
        output.setTerminate(false);

        String[] parsedCommand = params.getCommand().split(" ");
        try {
            switch (parsedCommand[0].toUpperCase()) {
                case "":
                    // 処理終了を設定
                    output.setTerminate(true);
                    break;
                case "T":
                    String queryWord = parsedCommand[1];
                    String translatedWord = book.findBy(queryWord);

                    if (translatedWord == null) {
                        output.setMessage(queryWord + " -> " + "登録されていません");
                    } else {
                        output.setMessage(queryWord + " -> " + translatedWord);
                    }
                    break;
                case "A":
                    String newWord = parsedCommand[1];
                    String newTranslatedWord = parsedCommand[2];
                    // 追加前に単語を削除
                    book.delete(newWord);
                    // 単語を追加
                    book.add(newWord, newTranslatedWord);
                    output.setMessage("登録しました");
                    break;
                case "D":
                    String deleteWord = parsedCommand[1];
                    book.delete(deleteWord);
                    output.setMessage("削除しました");
                    break;
                default:
                    // コマンドにミスがあったとき
                    output.setMessage("よくわかりませんでした");
                    break;
            }
        } catch (Exception e) {
            // コマンドにミスがあったとき
            output.setMessage("よくわかりませんでした");
        }
        return output;
    }
}

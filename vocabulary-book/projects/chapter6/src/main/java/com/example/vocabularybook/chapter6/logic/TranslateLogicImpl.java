package com.example.vocabularybook.chapter6.logic;

import com.example.vocabularybook.chapter6.dataaccess.BookAccessor;
import com.example.vocabularybook.chapter6.dto.TranslateLogicInDTO;
import com.example.vocabularybook.chapter6.dto.TranslateLogicOutDTO;

/**
 * 翻訳サービス実装
 */
public class TranslateLogicImpl implements TranslateLogic {

    // 単語帳データへのアクセス<1>
    private BookAccessor bookDao;

    // dataSourceプロパティへのアクセサ<2>
    public BookAccessor getBookDao() {
        return bookDao;
    }

    // dataSourceプロパティへのアクセサ<3>
    public void setBookDao(BookAccessor bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public TranslateLogicOutDTO execute(TranslateLogicInDTO params) {
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
                    String translatedWord = bookDao.findBy(queryWord);

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
                    bookDao.delete(newWord);
                    // 単語を追加
                    bookDao.add(newWord, newTranslatedWord);
                    output.setMessage("登録しました");
                    break;
                case "D":
                    String deleteWord = parsedCommand[1];
                    bookDao.delete(deleteWord);
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
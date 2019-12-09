package com.example.vocabularybook.chapter6.dataaccess;

/**
 * 単語帳データへのアクセサ
 */
public interface BookAccessor {
    /**
     * 語句を指定して翻訳語を探す
     *
     * @param queryWord 探したい語句
     * @return 翻訳語/存在しない場合はnull
     */
    String findBy(final String queryWord);

    /**
     * 語句を追加する
     *
     * @param newWord 追加する語句
     * @param newTranslatedWord 追加する翻訳語
     */
    void add(final String newWord, final String newTranslatedWord);

    /**
     * 語句を削除する
     *
     * @param deleteWord 削除する語句
     */
    void delete(final String deleteWord);
}

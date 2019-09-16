package com.example.vocabularybook.chapter3.dataaccess;

import java.util.HashMap;
import java.util.Map;

/**
 * 単語帳データへのアクセサ実装
 */
public class BookOnMemoryImpl implements BookAccessor {

    /** 単語格納場所 */
    private Map<String, String> memory = new HashMap<String, String>();

    @Override
    public String findBy(String queryWord) {
        return memory.get(queryWord);
    }

    @Override
    public void add(String newWord, String newTranslatedWord) {
        memory.put(newWord, newTranslatedWord);
    }

    @Override
    public void delete(String deleteWord) {
        memory.remove(deleteWord);
    }
}

package com.example.vocabularybook.chapter3.dataaccess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class BookAccessorTest {

    @Test
    public void bookTest01() {
        BookAccessor book = new BookOnMemoryImpl();
        book.delete("apple");
        book.add("apple", "りんご");
        // 追加した単語を翻訳する
        String translated = book.findBy("apple");

        assertThat(translated, is("りんご"));
    }

    @Test
    public void bookTest02() {
        BookAccessor book = new BookOnMemoryImpl();
        book.delete("apple");
        book.add("apple", "りんご");
        // 追加した単語を削除
        book.delete("apple");
        // 削除した単語を翻訳する
        String translated = book.findBy("apple");

        assertThat(translated, nullValue());
    }

    @Test
    public void bookTest03() {
        BookAccessor book = new BookOnMemoryImpl();
        book.delete("apple");
        book.add("apple", "りんご");
        // 再度インスタンスを生成（前のインスタンスは破棄される）
        book = new BookOnMemoryImpl();
        String translated = book.findBy("apple");
        // メモリ上に登録された単語はインスタンスが破棄されると消えてしまうことを確認する
        assertThat(translated, nullValue());
    }
}
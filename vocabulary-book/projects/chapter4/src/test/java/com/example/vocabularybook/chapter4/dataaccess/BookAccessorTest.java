package com.example.vocabularybook.chapter4.dataaccess;

import chapter4.dataaccess.BookAccessor;
import chapter4.dataaccess.BookOnFileImpl;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class BookAccessorTest {

    /**
     * 登録した単語の探索を行う
     */
    @Test
    public void bookTest01() {
        BookAccessor book = new BookOnFileImpl();
        book.delete("apple");
        book.add("apple", "りんご");
        // 追加した単語を探索する
        String lookup = book.findBy("apple");

        assertThat(lookup, is("りんご"));
    }

    /**
     * 削除した単語の探索を試みる
     */
    @Test
    public void bookTest02() {
        BookAccessor book = new BookOnFileImpl();
        book.delete("apple");
        book.add("apple", "りんご");
        // 追加した単語を削除
        book.delete("apple");
        // 削除した単語を探索する
        String lookup = book.findBy("apple");

        assertThat(lookup, nullValue());
    }

    /**
     * インスタンスを破棄した後、探索を試みる
     */
    @Test
    public void bookTest03() {
        BookAccessor book = new BookOnFileImpl();
        book.delete("apple");
        book.add("apple", "りんご");
        // 再度インスタンスを生成（前のインスタンスは破棄される）
        book = new BookOnFileImpl();
        String lookup = book.findBy("apple");
        // メモリ上に登録された単語はインスタンスが破棄されても消えないことを確認する
        assertThat(lookup, is("りんご"));
    }
}
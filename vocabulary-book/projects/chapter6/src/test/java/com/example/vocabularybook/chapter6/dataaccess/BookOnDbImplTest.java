package com.example.vocabularybook.chapter6.dataaccess;

import com.example.vocabularybook.chapter6.logic.TranslateLogic;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class BookOnDbImplTest {

    /**
     * 登録した単語の探索を行う
     */
    @Test
    public void bookTest01() {
        // Spring Framework 設定ファイルを読み込み
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Spring Framework が管理しているクラスよりインスタンスを取得する
        BookAccessor book = context.getBean(BookOnDbImpl.class);
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
        // Spring Framework 設定ファイルを読み込み
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Spring Framework が管理しているクラスよりインスタンスを取得する
        BookAccessor book = context.getBean(BookOnDbImpl.class);
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
        // Spring Framework 設定ファイルを読み込み
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Spring Framework が管理しているクラスよりインスタンスを取得する
        BookAccessor book = context.getBean(BookOnDbImpl.class);
        book.delete("apple");
        book.add("apple", "りんご");
        // 再度インスタンスを取得
        book = context.getBean(BookOnDbImpl.class);
        String lookup = book.findBy("apple");
        // メモリ上に登録された単語はインスタンスが破棄されても消えないことを確認する
        assertThat(lookup, is("りんご"));
    }
}
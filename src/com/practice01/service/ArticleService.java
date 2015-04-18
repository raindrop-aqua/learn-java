package com.practice01.service;

import com.practice01.dto.Article;

/**
 * 記事を扱うインターフェイス
 */
public interface ArticleService {

    /**
     * 年月を指定して記事を１件取得します
     *
     * この時の引数は検索条件のみとすると、あとから見た時にわかりやすい
     * つまり、業務ロジックに関係のあるもののみとしたい
     * 実装のみに必要な引数はなるべく加えないようにしたいところ。
     * 例えば、DBのコネクションなどは引数に加えたくない。
     *
     * @param year 年
     * @param month 月
     * @return 記事
     */
    Article read(int year, int month);
}

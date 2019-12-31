namespace java com.example.vocabularybook.chapter_extended1.thrift
namespace netstd com.example.vocabularybook.chapter_extended1.thrift
namespace csharp com.example.vocabularybook.chapter_extended1.thrift

/**
 * 単語帳サービス
 **/
service BookApi {
    /** 翻訳 */
    string search(1:string word),
    /** 単語を追加する */
    string addword(1:string word1, 2:string word2),
    /** 単語を削除する */
    string deleteWord(1:string word)
}

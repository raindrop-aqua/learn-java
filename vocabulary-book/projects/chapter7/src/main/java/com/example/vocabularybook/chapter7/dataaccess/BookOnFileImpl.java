package com.example.vocabularybook.chapter7.dataaccess;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class BookOnFileImpl implements BookAccessor {
    // ファイルの格納位置<1>
    String home = System.getProperty("user.dir");
    private String path = home + "/data/book.csv";
    private File file = new File(path);
    private Map<String, String> memory = new HashMap<String, String>();

    @Override
    public String findBy(String queryWord) {
        memory.clear();
        readAll();
        return memory.get(queryWord);
    }

    @Override
    public void add(String newWord, String newTranslatedWord) {
        // ファイルの内容をメモリに全て読み込み<2>
        readAll();
        // メモリに書き込み
        memory.put(newWord, newTranslatedWord);
        // 既存のファイルを削除<3>
        if (file.exists()) {
            file.delete();
        }
        // メモリの内容をすべてファイルに書き込み<4>
        writeAll();
    }

    @Override
    public void delete(String deleteWord) {
        // ファイルの内容をメモリに全て読み込み<2>
        readAll();
        // メモリより削除
        memory.remove(deleteWord);
        // 既存のファイルを削除<3>
        if (file.exists()) {
            file.delete();
        }
        // メモリの内容をすべてファイルに書き込み<4>
        writeAll();
    }

    /**
     * ファイルの内容をすべてメモリに読み込む
     */
    private void readAll() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file),
                        StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                memory.put(words[0], words[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * メモリの内容をすべてファイルに書き込む
     */
    private void writeAll() {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(file),
                        StandardCharsets.UTF_8))) {
            for (Map.Entry<String, String> item : memory.entrySet()) {
                String line = item.getKey() + "," + item.getValue();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

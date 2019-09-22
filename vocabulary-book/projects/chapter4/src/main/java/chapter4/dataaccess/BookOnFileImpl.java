package chapter4.dataaccess;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class BookOnFileImpl implements BookAccessor {

    private Map<String, String> memory = new HashMap<String, String>();
    private String path = "/Users/mss/Documents/learn-java/vocabulary-book/projects/chapter4/data/Book.csv";
    private File file = new File(path);


    @Override
    public String findBy(String queryWord) {
        memory.clear();
        readAll();
        return memory.get(queryWord);
    }

    @Override
    public void add(String newWord, String newTranslatedWord) {
        memory.put(newWord, newTranslatedWord);
        if (file.exists()) {
            file.delete();
        }
        writeAll();
    }

    @Override
    public void delete(String deleteWord) {
        memory.remove(deleteWord);
        if (file.exists()) {
            file.delete();
        }
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

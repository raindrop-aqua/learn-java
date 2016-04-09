package com.practice01.utils;

import java.io.File;
import java.net.URL;


/**
 * ファイルに関する部品クラス
 */
public class FileUtils {

    /**
     * クラスパスにあるファイルの絶対パスを取得します
     *
     * @param resourcePath クラスパス内でのパス
     * @return 絶対パス
     */
    public static String getFullPath(String resourcePath){
        String path = resourcePath;
        if (!resourcePath.startsWith("/")) {
            path =  "/" + path;
        }
        URL url = FileUtils.class.getResource(path);
        if (url == null) {
            return "";
        }
        return new File(url.getPath()).getAbsolutePath();
    }
}

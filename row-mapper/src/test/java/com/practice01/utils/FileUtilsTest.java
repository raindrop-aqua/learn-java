package com.practice01.utils;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class FileUtilsTest {

    @Test
    public void testGetFullPath_1() throws Exception {
        String filePath = FileUtils.getFullPath("article-2015-04.txt");
        File file = new File(filePath);
        assertEquals(true, file.exists());
    }

    @Test
    public void testGetFullPath_2() throws Exception {
        String filePath = FileUtils.getFullPath("aaa.txt");
        assertEquals("", filePath);
    }
}
package cn.alia.test;


import org.junit.Test;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestGetFileList {
    /**
     * 得到文件名称
     *
     * @param path 路径
     * @return {@link List}<{@link String}>
     */
    public List<String> getFileNames(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        List<String> fileNames = new ArrayList<>();
        return getFileNames(file, fileNames);
    }

    /**
     * 得到文件名称
     *
     * @param file      文件
     * @param fileNames 文件名
     * @return {@link List}<{@link String}>
     */
    public List<String> getFileNames(File file, List<String> fileNames) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getFileNames(f, fileNames);
            } else {
                fileNames.add(f.getName());
            }
        }
        return fileNames;
    }

    @Test
    public void testGetFileList() {
        String path = "D:\\360安全浏览器下载";
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            List<Path> fileNames = paths
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

            for (Path pathName : fileNames) {
                Boolean isDir = new File(String.valueOf(pathName)).isDirectory();
                if (isDir) {
                    System.out.println("文件夹===" + pathName);
                } else {
                    System.out.println("文  件===" + pathName);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testGetDirList() {
        String path = "D:\\360安全浏览器下载";
        File file = new File(path);
        File[] files = file.listFiles();

        for (File fileName : files) {
            Boolean isDir = new File(String.valueOf(fileName)).isDirectory();
            if (isDir) {
                System.out.println("文件夹===" + fileName);
            } else {
                System.out.println("文  件===" + fileName);
            }

        }

    }

@Test
    public void findUser() {

        String path = "D:\\360安全浏览器下载";
        File file = new File(path);
        File[] files = file.listFiles();
//        List<File> fileList = new ArrayList<>();
        for (File f : files) {

            Boolean isDir = file.isDirectory();
            if (isDir) {
                System.out.println("文件夹===" + f);
            } else {
                System.out.println("文  件===" + f);
            }
        }
        System.out.println("files=="+files);

    }


}
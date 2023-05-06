package cn.alia.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileController {

    @PostMapping("/findFileList")
    public void findUser(@RequestParam(defaultValue = "D:\\360安全浏览器下载") String filePath) {

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

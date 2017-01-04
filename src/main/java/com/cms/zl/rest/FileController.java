package com.cms.zl.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Vincent on 2017/1/2.
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${image.article.folder}")
    private String imageArticleFolder;

    @Value("${image.server}")
    private String imageServer;

    @Value("${serverUrl}")
    private String serverUrl;

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    @RequestMapping(value = "/uploadArticleImage", method = RequestMethod.POST)
    public String handleArticleImageFile(MultipartFile articleImageFile) {
        try {
            File newFile = new File(imageArticleFolder + df.format(new Date()) + "&" + articleImageFile.getOriginalFilename());
//            articleImageFile.transferTo(newFile); //存在bug，导致图片上传失败
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(newFile));
            out.write(articleImageFile.getBytes());
            out.flush();
            out.close();
            return imageServer + imageArticleFolder + newFile.getName();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageServer + "images/error.png";
    }
}

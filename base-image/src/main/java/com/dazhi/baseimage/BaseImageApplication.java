package com.dazhi.baseimage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class BaseImageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseImageApplication.class, args);
    }

    @RestController
    public static class UploadController{
        private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
        @Value("${upload-path}")
        private String uploadPath;
        @Value("${server.port}")
        private int serverPort;
        @Value("${upload-ip}")
        private String serverIp;

        @GetMapping("/upload")
        public String upload() {
            return "upload";
        }
        @PostMapping("/upload")
        public String upload(@RequestParam("file") MultipartFile file) {
            if (file.isEmpty()) {
                return "上传失败，请选择文件";
            }

            String fileName = file.getOriginalFilename();
            String filePath = uploadPath;

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                LOGGER.info("上传成功");
                return "http://"+serverIp+":"+serverPort+"/"+fileName;
            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
            }
            return "上传失败！";
        }
    }
}

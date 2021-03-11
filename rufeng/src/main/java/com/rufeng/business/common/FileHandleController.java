package com.rufeng.business.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/file-handler")
public class FileHandleController {
    private Logger log = LoggerFactory.getLogger(FileHandleController.class);

    /**
     * 上传文件存储在本地的根路径
     */
    @Value("${file.path}")
    private String localFilePath;


    /**
     * 文件上传
     * @param request
     * @param file
     * @throws FileNotFoundException
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public void  upload(HttpServletRequest request, MultipartFile file) throws FileNotFoundException {

    }

}

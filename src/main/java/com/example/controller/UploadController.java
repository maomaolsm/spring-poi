package com.example.controller;

import com.example.util.Poi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by maomao on 16/8/1.
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadController {

    @Autowired
    Poi poi;

    @RequestMapping(value = "/xlsx", method = RequestMethod.POST)
    public void xlsx(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
        if (null != multipartFile) {
            poi.xlsxTest(multipartFile);
        }
    }

    @RequestMapping(value = "/xls", method = RequestMethod.POST)
    public void xls(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
        if (null != multipartFile) {
            poi.xlsTest(multipartFile);
        }
    }
}

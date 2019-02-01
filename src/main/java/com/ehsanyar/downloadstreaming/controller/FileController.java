package com.ehsanyar.downloadstreaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileController {

    @Autowired
    FileControllerHandler fileControllerHandler;


    @RequestMapping(value = "/download/{fileName}", method = RequestMethod.GET)
    public void download(HttpServletRequest request,
                         HttpServletResponse response,
                         @PathVariable("fileName") String fileName) throws IOException {
        fileControllerHandler.processRequest(request, response, fileName, true);
    }

    @RequestMapping(value = "/download/{fileName}", method = RequestMethod.HEAD)
    public void downloadHead(HttpServletRequest request,
                             HttpServletResponse response,
                             @PathVariable("fileName") String fileName) throws IOException {
        fileControllerHandler.processRequest(request, response, fileName, false);
    }

}

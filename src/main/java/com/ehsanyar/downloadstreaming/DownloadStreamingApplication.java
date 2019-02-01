package com.ehsanyar.downloadstreaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HeaderParam;
import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class DownloadStreamingApplication {


    @Autowired
    FileControllerHandler fileControllerHandler;

    public static void main(String[] args) {
        SpringApplication.run(DownloadStreamingApplication.class, args);
    }


    @RequestMapping(value = "play/{fileName}", method = RequestMethod.GET)
    public void download(HttpServletRequest request,
                         HttpServletResponse response,
                         @PathVariable("fileName") String fileName,
                         @HeaderParam("Range") String range) throws IOException, ServletException {
        fileControllerHandler.processRequest(request, response, fileName, true);
    }

    @RequestMapping(value = "play/{fileName}", method = RequestMethod.HEAD)
    public void downloadHead(HttpServletRequest request,
                             HttpServletResponse response,
                             @PathVariable("fileName") String fileName) throws IOException, ServletException {
        fileControllerHandler.processRequest(request, response, fileName, false);
    }

}


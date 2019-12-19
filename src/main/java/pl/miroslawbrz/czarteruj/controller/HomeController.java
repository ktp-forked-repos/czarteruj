package pl.miroslawbrz.czarteruj.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {

        return "index";
    }

    @Autowired
    ServletContext servletContext;

    @ResponseBody
    @RequestMapping(value = "/image-resource", method = RequestMethod.GET)
    public Resource getImageAsResource() {
        return new ServletContextResource(servletContext, "/WEB-INF/images/baner.jpg");
    }



}
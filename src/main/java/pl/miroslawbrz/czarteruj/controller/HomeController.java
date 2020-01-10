package pl.miroslawbrz.czarteruj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.ServletContext;



@Controller
public class HomeController{

    private ServletContext servletContext;

    @Autowired
    public HomeController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @RequestMapping("/")
    public String home() {

        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/image-resource", method = RequestMethod.GET)
    public Resource getImageAsResource() {
        return new ServletContextResource(servletContext, "/WEB-INF/images/baner.jpg");
    }



}
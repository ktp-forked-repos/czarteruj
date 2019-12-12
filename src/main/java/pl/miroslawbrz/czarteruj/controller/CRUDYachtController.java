package pl.miroslawbrz.czarteruj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CRUDYachtController {

    @RequestMapping("/charterAdminPanel")
    @ResponseBody
    public String secured() {
        return "charterAdminPanel";
    }


}

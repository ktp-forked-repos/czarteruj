package pl.miroslawbrz.czarteruj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miroslawbrz.czarteruj.model.Yacht;
import pl.miroslawbrz.czarteruj.service.YachtService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CRUDYachtController {

    private YachtService yachtService;
    List<Yacht> yachtList = new ArrayList<>();

    public CRUDYachtController(YachtService yachtService) {
        this.yachtService = yachtService;
    }

    @RequestMapping("/charterAdminPanel")
    public String yachtRegistration(Model model) {
        yachtList.clear();
        yachtList = yachtService.getYachts();
        model.addAttribute("yacht", new Yacht());
        model.addAttribute("yachts", yachtList);
        return "charterAdminPanel";
    }

    @PostMapping("/addYacht")
    public String addYacht(@RequestBody Yacht yacht){

        yachtService.addYacht(yacht);
        return "redirect:/charterAdminPanel";
    }

    @DeleteMapping("/deleteYacht")
    public String deleteYacht(@RequestParam int id){
        yachtService.removeYacht(id);

        return "redirect:/charterAdminPanel";
    }




}

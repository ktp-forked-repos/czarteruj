package pl.miroslawbrz.czarteruj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miroslawbrz.czarteruj.model.CharterPlace;
import pl.miroslawbrz.czarteruj.model.User;
import pl.miroslawbrz.czarteruj.model.Yacht;
import pl.miroslawbrz.czarteruj.service.CharterPlaceService;
import pl.miroslawbrz.czarteruj.service.UserService;
import pl.miroslawbrz.czarteruj.service.YachtService;
import pl.miroslawbrz.czarteruj.utils.UserUtilities;

import java.util.ArrayList;
import java.util.List;

@Controller
public class YachtController {

    private YachtService yachtService;
    private CharterPlaceService charterPlaceService;
    private List<Yacht> yachtList = new ArrayList<>();

    @Autowired
    public YachtController(YachtService yachtService, CharterPlaceService charterPlaceService) {
        this.yachtService = yachtService;
        this.charterPlaceService = charterPlaceService;
    }

    @RequestMapping("/charterAdminPanel")
    public String yachtRegistration(@RequestBody Long charterPlaceId, Model model) {

        CharterPlace charterPlace = charterPlaceService.getCharterPlace(charterPlaceId);
        yachtList.clear();
        yachtList.addAll(charterPlace.getYachtList());
        model.addAttribute("yacht", new Yacht());
        model.addAttribute("yachts", yachtList);
        return "charterAdminPanel";
    }

    @PostMapping("/addYacht")
    public String addYacht(@RequestBody Long charterPlaceId, @RequestBody Yacht yacht){

        Long yachtId = yachtService.saveYachtAndGetId(yacht);
        yachtService.updateYachtsInCharterPlace(charterPlaceId, yachtId);
        return "redirect:/charterAdminPanel";
    }

    @DeleteMapping("/deleteYacht")
    public String deleteYacht(@RequestParam int id){
        yachtService.removeYacht(id);

        return "redirect:/charterAdminPanel";
    }




}

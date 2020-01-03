package pl.miroslawbrz.czarteruj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miroslawbrz.czarteruj.model.User;
import pl.miroslawbrz.czarteruj.model.Yacht;
import pl.miroslawbrz.czarteruj.service.UserService;
import pl.miroslawbrz.czarteruj.utils.UserUtilities;

import java.util.ArrayList;
import java.util.List;

@Controller
public class YachtController {

    private YachtService yachtService;
    private List<Yacht> yachtList = new ArrayList<>();
    private UserService userService;

    @Autowired
    public YachtController(YachtService yachtService, UserService userService) {
        this.yachtService = yachtService;
        this.userService = userService;
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
        String email = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(email);

        yachtService.addYacht(yacht);
        return "redirect:/charterAdminPanel";
    }

    @DeleteMapping("/deleteYacht")
    public String deleteYacht(@RequestParam int id){
        yachtService.removeYacht(id);

        return "redirect:/charterAdminPanel";
    }




}

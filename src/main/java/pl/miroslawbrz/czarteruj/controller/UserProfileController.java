package pl.miroslawbrz.czarteruj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.miroslawbrz.czarteruj.model.CharterPlace;
import pl.miroslawbrz.czarteruj.model.User;
import pl.miroslawbrz.czarteruj.service.CharterPlaceService;
import pl.miroslawbrz.czarteruj.service.UserService;
import pl.miroslawbrz.czarteruj.utils.UserUtilities;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private CharterPlaceService charterPlaceService;
    List<CharterPlace> charterPlaceList = new ArrayList<>();

    @GetMapping(value = "/profile")
    public String showUserProfilePage(Model model){
        charterPlaceList.clear();
        String userEmail = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(userEmail);
        charterPlaceList.addAll(user.getCharterPlaces());
        model.addAttribute("charterplaces", charterPlaceList);
        model.addAttribute("user", user);
        return "profile";
    }

}

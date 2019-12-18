package pl.miroslawbrz.czarteruj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.miroslawbrz.czarteruj.model.Address;
import pl.miroslawbrz.czarteruj.model.CharterPlace;
import pl.miroslawbrz.czarteruj.model.User;
import pl.miroslawbrz.czarteruj.service.CharterPlaceService;
import pl.miroslawbrz.czarteruj.service.UserService;
import pl.miroslawbrz.czarteruj.utils.JsonParse;
import pl.miroslawbrz.czarteruj.utils.UserUtilities;

@Controller
public class CharterPlaceController {

    @Autowired
    private UserService userService;
    @Autowired
    private CharterPlaceService charterPlaceService;

    private JsonParse jsonParse = new JsonParse();

    @GetMapping("/CharterPlace")
    public String formCharterPlace(Model model){
        model.addAttribute("CharterPlace" , new CharterPlace());
        return "charterPlace";
    }

    @PostMapping("/addCharterPlace")
    public String addCharterPlace(CharterPlace charterPlace, Address address){

        String userEmail = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(userEmail);

        charterPlace.setAddress(address);
        jsonParse.setFullAddressAndCoordinatesFromApi(charterPlace);

        Long userId = user.getId();
        Long charterId = charterPlaceService.saveCharterPlaceAndGetId(charterPlace);
        charterPlaceService.updateUsersCharterPlaces(userId, charterId);

        return "profile";
    }

}

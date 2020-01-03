package pl.miroslawbrz.czarteruj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.miroslawbrz.czarteruj.model.CharterPlace;
import pl.miroslawbrz.czarteruj.service.CharterPlaceService;

import java.util.List;

@RestController
@RequestMapping("/api/charters")
public class CharterRestController {

    private CharterPlaceService charterPlaceService;

    @Autowired
    public CharterRestController(CharterPlaceService charterPlaceService) {
        this.charterPlaceService = charterPlaceService;
    }

    @GetMapping
    public ResponseEntity<List<CharterPlace>> allProducts() {
        List<CharterPlace> charterPlaces = charterPlaceService.getCharterPlaces();
        return ResponseEntity.ok(charterPlaces);
    }

}

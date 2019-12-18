package pl.miroslawbrz.czarteruj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.miroslawbrz.czarteruj.model.CharterPlace;
import pl.miroslawbrz.czarteruj.model.User;
import pl.miroslawbrz.czarteruj.repository.CharterPlaceRepository;

import java.util.List;

@Service
public class CharterPlaceService {

    @Autowired
    private CharterPlaceRepository charterPlaceRepository;

    public CharterPlaceService(CharterPlaceRepository charterPlaceRepository) {
        this.charterPlaceRepository = charterPlaceRepository;
    }

    public CharterPlace getCharterPlace(long id){
        return charterPlaceRepository.getOne(id);
    }

    public List<CharterPlace> getCharterPlaces(){
        return charterPlaceRepository.findAll();
    }

    public void updateCharterPlace(CharterPlace charterPlace){
        CharterPlace charterPlacefromDB = charterPlaceRepository.getOne(charterPlace.getId());
        charterPlacefromDB.setCharterPlaceName(charterPlace.getCharterPlaceName());
        charterPlacefromDB.setAddress(charterPlace.getAddress());
        charterPlacefromDB.setMapLatitude(charterPlace.getMapLatitude());
        charterPlacefromDB.setMapLongitude(charterPlace.getMapLongitude());
    }

    public Long saveCharterPlaceAndGetId(CharterPlace charterPlace){
        return charterPlaceRepository.save(charterPlace).getId();

    }

    public void updateUsersCharterPlaces(Long userId, Long charterPlaceId){
        charterPlaceRepository.addCharterPlaceToUser(userId, charterPlaceId);
    }


}

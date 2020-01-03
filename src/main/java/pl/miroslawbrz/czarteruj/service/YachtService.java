package pl.miroslawbrz.czarteruj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.miroslawbrz.czarteruj.model.CharterPlace;
import pl.miroslawbrz.czarteruj.model.Yacht;
import pl.miroslawbrz.czarteruj.repository.YachtRepository;

import java.util.List;

@Service
public class YachtService{


    private YachtRepository yachtRepository;

    @Autowired
    public YachtService(YachtRepository yachtRepository) {
        this.yachtRepository = yachtRepository;
    }

    public void addYacht(Yacht yacht){
        yachtRepository.save(yacht);
    }


    public void removeYacht(int id) {
        yachtRepository.deleteById(id);
    }


    public Yacht getYacht(int id) {
        return yachtRepository.getOne(id);
    }

    public List<Yacht> getYachts() {
        return yachtRepository.findAll();
    }

    public Long saveYachtAndGetId(Yacht yacht) {
        return yachtRepository.save(yacht).getId();
    }
    public void updateUsersCharterPlaces(Long charterPlaceId, Long yachtId){
        yachtRepository.addYachtToCharterPlace(charterPlaceId, yachtId);
    }

}
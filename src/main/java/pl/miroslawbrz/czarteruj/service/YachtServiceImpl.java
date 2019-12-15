package pl.miroslawbrz.czarteruj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.miroslawbrz.czarteruj.model.Yacht;
import pl.miroslawbrz.czarteruj.repository.YachtRepository;

import java.util.List;

@Service
public class YachtServiceImpl implements YachtService{


    private YachtRepository yachtRepository;

    @Autowired
    public YachtServiceImpl(YachtRepository yachtRepository) {
        this.yachtRepository = yachtRepository;
    }
    @Override
    public void addYacht(Yacht yacht){
        yachtRepository.save(yacht);
    }

    @Override
    public void removeYacht(int id) {
        yachtRepository.deleteById(id);
    }

    @Override
    public Yacht getYacht(int id) {
        return yachtRepository.getOne(id);
    }

    @Override
    public List<Yacht> getYachts() {
        return yachtRepository.findAll();
    }

}

package pl.miroslawbrz.czarteruj.service;

import pl.miroslawbrz.czarteruj.model.Yacht;

import java.util.List;

public interface YachtService {

    void addYacht(Yacht yacht);
    void removeYacht(int id);
    Yacht getYacht(int id);
    List<Yacht> getYachts();
    }



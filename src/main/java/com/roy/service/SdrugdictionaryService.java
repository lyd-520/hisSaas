package com.roy.service;

import com.roy.entity.Area;
import com.roy.entity.Sdrugdictionary;
import com.roy.entity.Type;
import com.roy.entity.Unit;
import com.roy.mapper.SdrugdictionaryMapper;

import java.util.List;

public interface SdrugdictionaryService{
    List<SdrugdictionaryMapper> findAllSdrugdictionary(Sdrugdictionary sdrugdictionary);
    int addSdrugdictionary(Sdrugdictionary sdrugdictionary);
    int editSdrugdictionary(Sdrugdictionary sdrugdictionary);
    int deleteSdrugdictionary(Integer drugId);
    List<Unit> findAllUnit();
    List<Area> findAllArea();
    List<Type> findAllType();
    int count(Sdrugdictionary sdrugdictionary);
}

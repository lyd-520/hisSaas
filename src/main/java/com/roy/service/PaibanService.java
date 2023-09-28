package com.roy.service;

import com.roy.entity.Ban;
import com.roy.entity.Paiban;

import java.util.List;

public interface PaibanService{
    List<Paiban> findAllPaiban(Paiban paiban);
    int editPaiban(Paiban paiban);
    List<Ban> findAllBan();
    int insertPaiban(Paiban paiban);
    int count(Integer Id);
}

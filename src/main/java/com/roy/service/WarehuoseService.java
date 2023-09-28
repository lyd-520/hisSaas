package com.roy.service;

import com.roy.entity.Warehuose;

import java.util.List;

public interface WarehuoseService{
    List<Warehuose> findAllWarehuose(Warehuose warehuose);
    int deleteWarehuose(Integer warehouseId);
    int addWarehuose(Warehuose warehuose);
    int count(Warehuose warehuose);
}

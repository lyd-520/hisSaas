package com.roy.service.Impl;

import com.roy.entity.Area;
import com.roy.mapper.AreaMapper;
import com.roy.service.AreaService;
import com.roy.service.SaasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AreaServiceImpl extends SaasService implements AreaService {
    @Resource
    private AreaMapper areaMapper;
    @Override
    public List<Area> findAllArea(Area area) {
        return areaMapper.findAllArea(area);
    }

    @Override
    public int deleteArea(Integer areaId) {
        return areaMapper.deleteArea(areaId);
    }

    @Override
    public int addArea(Area area) {
        return areaMapper.addArea(area);
    }


    @Override
    public int count(Area area) {
        return areaMapper.count(area);
    }
}

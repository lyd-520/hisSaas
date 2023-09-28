package com.roy.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.roy.entity.HospitalMeta;
import com.roy.mapper.HospitalMapper;
import com.roy.util.InitDBUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@DS("master")
public class HospitalService {

    @Resource
    private HospitalMapper hospitalMapper;

    public List<HospitalMeta> selectAll(HospitalMeta hospital) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(null != hospital.getHospitalId() && hospital.getHospitalId()>0){
            queryWrapper.eq("hospitalId",hospital.getHospitalId());
        }
        if(StringUtils.hasText(hospital.getMysqlUrl())){
            queryWrapper.like("mysqlUrl",hospital.getMysqlUrl());
        }
        return hospitalMapper.selectList(queryWrapper);
    }

    public List<HospitalMeta> selectAvailable(HospitalMeta hospital) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(null != hospital.getHospitalId() && hospital.getHospitalId()>0){
            queryWrapper.eq("hospitalId",hospital.getHospitalId());
        }
        if(StringUtils.hasText(hospital.getMysqlUrl())){
            queryWrapper.like("mysqlUrl",hospital.getMysqlUrl());
        }
        queryWrapper.eq("mysqlStatus",1);
        return hospitalMapper.selectList(queryWrapper);
    }

    public void addHospital(HospitalMeta hospital) {
        hospitalMapper.insert(hospital);
    }

    public void updateHospital(HospitalMeta hospital) {
        hospitalMapper.updateById(hospital);
    }

    public void deleteHospital(int hospitalId) {
        hospitalMapper.deleteById(hospitalId);
    }

    public List<HospitalMeta> selectBySchema(String mysqlSchema) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("mysqlSchema",mysqlSchema);
        return hospitalMapper.selectList(queryWrapper);
    }

    public boolean initDB(HospitalMeta hospital) {
        return InitDBUtil.initDB(hospital.getMysqlUrl(),hospital.getMysqlSchema(),hospital.getMysqlUsername(),hospital.getMysqlPassword());
    }

    public boolean tryConnectDB(HospitalMeta hospital) {
        return InitDBUtil.tryConnectDB(hospital.getMysqlUrl(),hospital.getMysqlSchema(),hospital.getMysqlUsername(),hospital.getMysqlPassword());
    }
}

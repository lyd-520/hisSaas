package com.roy.service.Impl;

import com.roy.entity.Finance;
import com.roy.entity.SdoctorDuibi;
import com.roy.entity.currentFinance;
import com.roy.mapper.FinanceMapper;
import com.roy.service.FinanceService;
import com.roy.service.SaasService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FinanceServiceImpl extends SaasService implements FinanceService {
    @Resource
    private FinanceMapper FinanceMapper;
    @Override
    public List<Double> reportYearFinance(String year) {
        return FinanceMapper.reportYearFinance(year);
    }

    @Override
    public List<Finance> reportYearBingFinance() {
        return FinanceMapper.reportYearBingFinance();
    }

    @Override
    public List<Double> zhuYuanYearFinance(String year) {
        return FinanceMapper.zhuYuanYearFinance(year);
    }

    @Override
    public List<Finance> zhuYuanYearBingFinance() {
        return FinanceMapper.zhuYuanYearBingFinance();
    }

    @Override
    public List<SdoctorDuibi> doctorDuibi(SdoctorDuibi sdoctorDuibi) {
        return FinanceMapper.doctorDuibi(sdoctorDuibi);
    }

    @Override
    public List<SdoctorDuibi> zDoctorDuibi(SdoctorDuibi sdoctorDuibi) {
        return FinanceMapper.zDoctorDuibi(sdoctorDuibi);
    }

    @Override
    public List<currentFinance> currentFinance(String current) {
        return FinanceMapper.currentFinance(current);
    }
}

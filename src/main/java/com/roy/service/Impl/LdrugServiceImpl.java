package com.roy.service.Impl;

import com.roy.entity.Lpharmacy;
import com.roy.entity.Lrecord;
import com.roy.mapper.LdrugMapper;
import com.roy.service.LdrugService;
import com.roy.service.SaasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class LdrugServiceImpl extends SaasService implements LdrugService {

    @Resource
    private LdrugMapper ldrugMapper;

    @Override
    public List<Lpharmacy> selDrug(Lpharmacy lpharmacy) {
        return ldrugMapper.selDrug(lpharmacy);
    }

    @Override
    public List<Lrecord> selDrugs(Lrecord lrecord) {
        return ldrugMapper.selDrugs(lrecord);
    }

    @Override
    public int addDrug(Lrecord lrecord) {
        return ldrugMapper.addDrug(lrecord);
    }

    @Override
    public int updDrug(Lrecord lrecord) {
        return ldrugMapper.updDrug(lrecord);
    }

    @Override
    public int delDrug(Lrecord lrecord) {
        return ldrugMapper.delDrug(lrecord);
    }

    @Override
    public int updDrugs(Lrecord lrecord) {
        return ldrugMapper.updDrugs(lrecord);
    }

    @Override
    public int updNum(Lrecord lrecord) {
        return ldrugMapper.updNum(lrecord);
    }

    @Override
    public int upd(Lrecord lrecord) {
        return ldrugMapper.upd(lrecord);
    }
}

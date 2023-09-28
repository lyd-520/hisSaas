package com.roy.service.Impl;

import com.roy.entity.CCashier;
import com.roy.entity.CPharmacy;
import com.roy.entity.Coutpatienttype;
import com.roy.entity.ReportVo;
import com.roy.mapper.COutMapper;
import com.roy.service.COutService;
import com.roy.service.SaasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class COutServiceImpl extends SaasService implements COutService {
    @Resource
    private COutMapper cOutMapper;
    //查询门诊收费项目
    @Override
    public List<CPharmacy> selout(Coutpatienttype coutpatienttype) {
        return cOutMapper.selout(coutpatienttype);
    }
    //查询该用户的处方中是否有该项目
    @Override
    public Integer selchuo(CCashier cCashier) {
        return cOutMapper.selchuo(cCashier);
    }
    //给该项目添加到处方表
    @Override
    public Integer addchuo(CCashier cCashier) {
        return cOutMapper.addchuo(cCashier);
    }
    //修改该项目的数量
    @Override
    public Integer updchuo(CCashier cCashier) {
        return cOutMapper.updchuo(cCashier);
    }
    //删除处方中的项目
    @Override
    public Integer delo(CCashier cCashier) {
        return cOutMapper.delo(cCashier);
    }
    //查询该用户的处方价格
    @Override
    public Double selch(CCashier cCashier) {
        return cOutMapper.selch(cCashier);
    }

    @Override
    public Integer shoufei(ReportVo reportVo) {
        return cOutMapper.shoufei(reportVo);
    }

    @Override
    public Integer guafei(ReportVo reportVo) {
        return cOutMapper.guafei(reportVo);
    }
}

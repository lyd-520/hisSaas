package com.roy.service.Impl;

import com.roy.entity.Lcheckup;
import com.roy.mapper.CheckupMapper;
import com.roy.service.CheckupService;
import com.roy.service.SaasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CheckupServiceImpl extends SaasService implements CheckupService {

    @Resource
    private CheckupMapper checkupMapper;

    @Override
    public int addCheckup(Lcheckup lcheckup) {
        return checkupMapper.addCheckup(lcheckup);
    }

    @Override
    public int updPrice(Lcheckup lcheckup) {
        return checkupMapper.updPrice(lcheckup);
    }

    @Override
    public List<Lcheckup> selCheckup(Lcheckup lcheckup) {
        return checkupMapper.selCheckup(lcheckup);
    }
}

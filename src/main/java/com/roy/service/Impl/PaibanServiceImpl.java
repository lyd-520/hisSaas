package com.roy.service.Impl;

import com.roy.entity.Ban;
import com.roy.entity.Paiban;
import com.roy.mapper.PaibanMapper;
import com.roy.service.PaibanService;
import com.roy.service.SaasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PaibanServiceImpl extends SaasService implements PaibanService {
    @Resource
    private PaibanMapper paibanMapper;
    @Override
    public List<Paiban> findAllPaiban(Paiban paiban) {
        return paibanMapper.findAllPaiban(paiban);
    }

    @Override
    public int editPaiban(Paiban paiban) {
        return paibanMapper.editPaiban(paiban);
    }

    @Override
    public List<Ban> findAllBan() {
        return paibanMapper.findAllBan();
    }
    @Override
    public int insertPaiban(Paiban paiban) {
        return paibanMapper.insertPaiban(paiban);
    }

    @Override
    public int count(Integer Id) {
        return paibanMapper.count(Id);
    }
}

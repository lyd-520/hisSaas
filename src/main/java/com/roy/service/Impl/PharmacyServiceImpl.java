package com.roy.service.Impl;

import com.roy.entity.Baoque;
import com.roy.entity.Huishou;
import com.roy.entity.Ypharmacy;
import com.roy.mapper.PharmacyMapper;
import com.roy.service.PharmacyService;
import com.roy.service.SaasService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PharmacyServiceImpl extends SaasService implements PharmacyService {
    @Resource
    private PharmacyMapper pm;
    @Override
    public List<Ypharmacy> selpharmacy(Ypharmacy ypharmacy) {
        return pm.selpharmacy(ypharmacy);
    }

    @Override
    public int addbaoque(Baoque baoque) {
        return pm.addbaoque(baoque);
    }

    @Override
    public int selbaoqueName(Baoque baoque) {
        return pm.selbaoqueName(baoque);
    }

    @Override
    public int upbaoquenum(Baoque baoque) {
        return pm.upbaoquenum(baoque);
    }

    @Override
    public int delpharymacy(Ypharmacy ypharmacy) {
        return pm.delpharymacy(ypharmacy);
    }

    @Override
    public int addhuishou(Huishou huishou) {
        return pm.addhuishou(huishou);
    }

    @Override
    public List<Huishou> selhuishou(Huishou huishou) {
        return pm.selhuishou(huishou);
    }

    @Override
    public int delhuishou(Huishou huishou) {
        return pm.delhuishou(huishou);
    }


}

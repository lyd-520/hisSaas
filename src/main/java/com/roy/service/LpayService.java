package com.roy.service;

import com.roy.entity.Lrecord;
import com.roy.entity.Pay;
import com.roy.entity.Register;

import java.util.List;

public interface LpayService{

    int updPay(Register register);
    int addPay(Register register);
    List<Pay> selPays(Register register);
    List<Lrecord> selSurplus(Lrecord lrecord);
}

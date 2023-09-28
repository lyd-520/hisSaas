package com.roy.service.Impl;

import com.roy.entity.Record;
import com.roy.mapper.RecordMapper;
import com.roy.service.RecordService;
import com.roy.service.SaasService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecordServiceImpl extends SaasService implements RecordService {
    @Resource
    private RecordMapper rd;
    @Override
    public List<Record> selrecord(Record record) {
        return rd.selrecord(record);
    }

    @Override
    public int addjilu(Record record) {
        return rd.addjilu(record);
    }
}

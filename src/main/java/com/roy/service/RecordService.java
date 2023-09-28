package com.roy.service;

import com.roy.entity.Record;

import java.util.List;

public interface RecordService{
    //查询所有记录
    List<Record> selrecord(Record record);
    //添加记录
    int addjilu(Record record);
}

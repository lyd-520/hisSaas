package com.roy.controller;


import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roy.config.DynamicDatasourceConfig;
import com.roy.entity.HospitalMeta;
import com.roy.service.HospitalService;
import com.roy.util.InitDBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hospital")
public class HostiptalController {

    private Logger logger = LoggerFactory.getLogger(HostiptalController.class);

    @Resource
    private HospitalService hospitalService;

    @Resource
    private DynamicDatasourceConfig dynamicDatasourceConfig;

    @Resource
    private DynamicRoutingDataSource datasources;

    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll(Integer page, Integer limit, HospitalMeta hospital){
        PageHelper.startPage(page, limit);
        List<HospitalMeta> allHospital = hospitalService.selectAll(hospital);
        PageInfo pageInfo = new PageInfo(allHospital);
        Map<String, Object> tableData = new HashMap<>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());

        return tableData;
    }

    @RequestMapping("/addhospital")
    @ResponseBody
    public Object addhospital(HospitalMeta hospital){
        try{
            if(checkSchema(hospital.getMysqlSchema())){
                hospitalService.addHospital(hospital);
                return "添加成功";
            }else{
                return "schema已经存在";
            }
        }catch (Exception e){
            return "添加失败，"+e.getMessage();
        }
    }

    private boolean checkSchema(String mysqlSchema) {
        if(hospitalService.selectBySchema(mysqlSchema).size()>0){
            return false;
        }
        return true;
    }

    @RequestMapping("/updatehospital")
    @ResponseBody
    public Object updatehospital(HospitalMeta hospital){
        try{
            hospitalService.updateHospital(hospital);
            return "更新成功";
        }catch (Exception e){
            return "更新失败，"+e.getMessage();
        }
    }

    @RequestMapping("/deletehospital")
    @ResponseBody
    public Object deletehospital(int hospitalId){
        try{
            hospitalService.deleteHospital(hospitalId);
            //删库

            return "删除成功";
        }catch (Exception e){
            return "删除失败，"+e.getMessage();
        }
    }

    @RequestMapping("/inithospitalDB")
    @ResponseBody
    public Object inithospitalDB(HospitalMeta hospital){
        try{
            //建库
            if(hospitalService.initDB(hospital)){
                //更新状态
                hospital.setMysqlStatus(1);
                hospitalService.updateHospital(hospital);

                //更新缓存
                dynamicDatasourceConfig.addDB(hospital);
                return "数据库创建成功";
            }
            return "数据库创建失败，请确认MySQL信息";
        }catch (Exception e){
            return "数据库创建失败，"+e.getMessage();
        }
    }

    @RequestMapping("/connectDB")
    @ResponseBody
    public Object connectDB(HospitalMeta hospital){
        if(hospitalService.tryConnectDB(hospital)){
            return "数据库连接正常";
        }
        return "数据库连接失败，请确认MySQL信息后尝试重建数据库";
    }

    @ResponseBody
    @RequestMapping(value = "/queryHospital",method = RequestMethod.POST)
    public Object queryHospital(){
        List<Map<String ,String>> result = new ArrayList<>();
        for (String hosiptalSchema : datasources.getDataSources().keySet()) {
            Map<String,String> hospitalInfo = new HashMap<>();
            hospitalInfo.put("mysqlSchema",hosiptalSchema);
            hospitalInfo.put("hospitalName", dynamicDatasourceConfig.getHospitalNameBySchema(hosiptalSchema));
            result.add(hospitalInfo);
        }
        return result;
    }
}

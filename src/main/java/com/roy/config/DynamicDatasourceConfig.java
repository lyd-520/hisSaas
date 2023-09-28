package com.roy.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.roy.entity.HospitalMeta;
import com.roy.service.HospitalService;
import com.roy.util.InitDBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class  DynamicDatasourceConfig {

    private Logger logger = LoggerFactory.getLogger(DynamicDatasourceConfig.class);

    private Map<String, String> hospitalTable = new HashMap<>();

    @Resource
    private HospitalService hospitalService;

    @Resource
    private DynamicRoutingDataSource dataSource;

    @PostConstruct
    public void loadAllDB(){
        hospitalTable.put("master","管理中心");
        List<HospitalMeta> hospitalMetas = hospitalService.selectAvailable(new HospitalMeta());
        for (HospitalMeta hospitalMeta:hospitalMetas){
            DruidDataSource tmpdb = InitDBUtil.getInitDBConfig();
            tmpdb.setUsername(hospitalMeta.getMysqlUsername());
            tmpdb.setPassword(hospitalMeta.getMysqlPassword());
            tmpdb.setUrl("jdbc:mysql://"+hospitalMeta.getMysqlUrl()+"/"+hospitalMeta.getMysqlSchema()+"?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
            dataSource.addDataSource(hospitalMeta.getMysqlSchema(),tmpdb);
            logger.info("======加载动态数据库完成：mysqlSchema="+hospitalMeta.getMysqlSchema());

            hospitalTable.put(hospitalMeta.getMysqlSchema(),hospitalMeta.getHospitalName());
        }
    }
    //初始化医院的mysql库后，动态增加缓存。
    public void addDB(HospitalMeta hospitalMeta){
        DruidDataSource tmpdb = InitDBUtil.getInitDBConfig();
        tmpdb.setUsername(hospitalMeta.getMysqlUsername());
        tmpdb.setPassword(hospitalMeta.getMysqlPassword());
        tmpdb.setUrl("jdbc:mysql://"+hospitalMeta.getMysqlUrl()+"/"+hospitalMeta.getMysqlSchema()+"?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        dataSource.addDataSource(hospitalMeta.getMysqlSchema(),tmpdb);
        logger.info("======加载添加数据库完成：mysqlSchema="+hospitalMeta.getMysqlSchema());

        hospitalTable.put(hospitalMeta.getMysqlSchema(),hospitalMeta.getHospitalName());
    }
    //删除缓存--懒得做了。
    public void deleteDB(){

    }

    public String getHospitalNameBySchema(String schema){
        return hospitalTable.containsKey(schema)?hospitalTable.get(schema):"";
    }
}

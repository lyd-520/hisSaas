package com.roy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("hospitalmeta")
public class HospitalMeta {
    @TableId("hospitalId")
    private Integer hospitalId;
    @TableField("hospitalName")
    private String hospitalName;
    @TableField("hospitalAddress")
    private String hospitalAddress;
    @TableField("mysqlUrl")
    private String mysqlUrl;
    @TableField("mysqlSchema")
    private String mysqlSchema;
    @TableField("mysqlUsername")
    private String mysqlUsername;
    @TableField("mysqlPassword")
    private String mysqlPassword;
    //0-未建库;1-已建库
    @TableField("mysqlStatus")
    private int mysqlStatus = 0;

    @Override
    public String toString() {
        return "HospitalMeta{" +
                "hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalAddress='" + hospitalAddress + '\'' +
                ", mysqlUrl='" + mysqlUrl + '\'' +
                ", mysqlSchema='" + mysqlSchema + '\'' +
                ", mysqlUsername='" + mysqlUsername + '\'' +
                ", mysqlPassword='" + mysqlPassword + '\'' +
                ", mysqlStatus=" + mysqlStatus +
                '}';
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getMysqlUrl() {
        return mysqlUrl;
    }

    public void setMysqlUrl(String mysqlUrl) {
        this.mysqlUrl = mysqlUrl;
    }

    public String getMysqlUsername() {
        return mysqlUsername;
    }

    public void setMysqlUsername(String mysqlUsername) {
        this.mysqlUsername = mysqlUsername;
    }

    public String getMysqlPassword() {
        return mysqlPassword;
    }

    public void setMysqlPassword(String mysqlPassword) {
        this.mysqlPassword = mysqlPassword;
    }

    public String getMysqlSchema() {
        return mysqlSchema;
    }

    public void setMysqlSchema(String mysqlSchema) {
        this.mysqlSchema = mysqlSchema;
    }

    public int getMysqlStatus() {
        return mysqlStatus;
    }

    public void setMysqlStatus(int mysqlStatus) {
        this.mysqlStatus = mysqlStatus;
    }
}

package com.roy.service;

import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * SaasService接口。该接口下的所有数据操作默认根据session中的,hospitalSchema进行路由。
 */
@DS("#session.hospitalSchema")
public class SaasService {
}

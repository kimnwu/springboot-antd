package com.ucsmy.ucas.manage.service.impl;

import com.ucsmy.commons.utils.StringUtils;
import com.ucsmy.ucas.manage.service.SecurityService;
import com.ucsmy.ucas.manage.service.SysCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.stereotype.Service;

/**
 * Created by cui on 2017/6/23.
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    private final static int INVALID_TIME = 30 * 60;
    private final static int DEFAULT_LEVEL = -1;
    private final static String KEY = "ucsmy:manage:system:security:";

    @Autowired
    private SysCacheService cacheService;

    @Autowired
    private SessionProperties sessionProperties;

    @Override
    public <T> String genSecurityCode(T data, Business business) {
        return genSecurityCode(business, DEFAULT_LEVEL, data, INVALID_TIME);
    }

    @Override
    public <T> String genSecurityCode(T data, int invalidTime, Business business) {
        return genSecurityCode(business, DEFAULT_LEVEL, data, invalidTime);
    }

    @Override
    public <T> String  genSecurityCode(Business business, int level, T data) {
        return genSecurityCode(business, level, data, INVALID_TIME);
    }

    @Override
    public <T> String  genSecurityCode(Business business, int level, T data, int invalidTime) {
        Security security = Security.builder()
                .code(StringUtils.getUUID())
                .business(business.toString())
                .level(level)
                .data(data)
                .build();
        cacheService.set(getKey(security.getCode()), security, (long) invalidTime);
        return security.getCode();
    }

    @Override
    public <T> Security<T> getSecurityCode(String code, Business business) {
        return getSecurityCode(code, business, DEFAULT_LEVEL);
    }

    @Override
    public <T> Security<T> getSecurityCode(String code, Business business, int level) {
        if(code == null || business == null)
            return null;
        Security<T> security = cacheService.get(getKey(code));
        if(security != null && security.getBusiness().equals(business.toString()) && security.getLevel() == level) {
            return security;
        }
        return null;
    }

    @Override
    public void deleteSecurityCode(String code) {
        if(code == null)
            return;
        cacheService.delete(getKey(code));
    }

    private String getKey(String code) {
        String namespace = sessionProperties.getRedis().getNamespace();
        if(StringUtils.isEmpty(namespace)) {
            return KEY.concat(code);
        } else {
            return KEY.concat(sessionProperties.getRedis().getNamespace()).concat(":").concat(code);
        }
    }
}

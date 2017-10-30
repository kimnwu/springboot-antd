package com.ucsmy.ucas.manage.service;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by cui on 2017/6/23.
 */
public interface SecurityService {
    /**
     * 生成安全码
     */
    <T> String  genSecurityCode(T data, Business business);

    /**
     * 生成安全码
     */
    <T> String  genSecurityCode(T data, int invalidTime, Business business);

    /**
     * 生成安全码
     */
    <T> String  genSecurityCode(Business business, int level, T data);

    /**
     * 生成安全码
     * @param business 业务
     * @param level 业务层次
     * @param data 业务数据
     * @param invalidTime 失效时间，单位秒
     */
    <T> String  genSecurityCode(Business business, int level, T data, int invalidTime);

    /**
     * 校验安全码是否在业务对应层次
     */
    <T> Security<T> getSecurityCode(String code, Business business);

    /**
     * 校验安全码是否在业务对应层次
     * @param code 安全码
     * @param business 业务
     * @param level 业务层次
     */
    <T> Security<T> getSecurityCode(String code, Business business, int level);

    /**
     * 删除安全码
     * @param code 安全码
     */
    void deleteSecurityCode(String code);

    enum Business {
        REG("注册", "reg"),
        FORGET_PWD("找回密码", "update_pwd"),
        UPDATE_PHONE("修改手机", "update_phone"),
        CAPTCHA("验证码", "captcha");

        private String value;
        private String name;

        Business(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    @Data
    @NoArgsConstructor
    class Security<T> {
        private String code;
        private String business;
        private int level;
        private T data;

        @Builder
        public Security(String code, String business, int level, T data) {
            this.code = code;
            this.business = business;
            this.level = level;
            this.data = data;
        }
    }
}

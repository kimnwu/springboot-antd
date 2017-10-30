package com.ucsmy.commons.utils;

/**
 * 授权类型枚举类
 * Created by ucs_xiaokailin on 2017/4/26.
 */
public enum GrantTypeEnum {
    AUTHORIZATION_CODE("authorization_code"),
    PASSWORD("password"),
    CLIENT_CREDENTIALS("client_credentials"),
    REFRESH_TOKEN("refresh_token"),
    PROXY_AUTHORIZATION_CODE("proxy_authorization_code");

    private String value;

    GrantTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package com.ucsmy.ucas.manage.entity;

import com.ucsmy.commons.bean.BaseNode;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Data
public class ManageLogInfo extends BaseNode {
    private Date createTime;

    private String ipAddress;

    private String logLevel;

    private String message;

    private String userName;

    private String userId;

}
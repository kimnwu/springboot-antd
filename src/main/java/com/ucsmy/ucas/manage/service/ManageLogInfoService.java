package com.ucsmy.ucas.manage.service;

import com.ucsmy.ucas.manage.entity.ManageLogInfo;

/**
 * manageLogInfo service
 * Created by chenqilin on 2017/5/8.
 */
public interface ManageLogInfoService {

    /**
     * 添加logInfo
     * @param manageLogInfo
     * @return
     */
    int addManageLogInfo(ManageLogInfo manageLogInfo);
}

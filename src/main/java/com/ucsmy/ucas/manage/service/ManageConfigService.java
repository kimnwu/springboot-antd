package com.ucsmy.ucas.manage.service;

import com.ucsmy.commons.service.BasicService;
import com.ucsmy.ucas.manage.entity.ManageConfig;
import com.ucsmy.ucas.manage.ext.RetMsg;

public interface ManageConfigService extends BasicService<ManageConfig> {
    /**
     * 更改状态
     */
    RetMsg updateStatus(String id);
}

package com.ucsmy.ucas.manage.service;

import com.ucsmy.commons.service.BasicService;
import com.ucsmy.ucas.manage.entity.ManageIpScheduleTask;
import com.ucsmy.ucas.manage.ext.RetMsg;

/**
 * 定时任务Service
 *
 * @author chenqilin
 * @since 2017/9/7
 */

public interface ManageScheduleTaskService extends BasicService<ManageIpScheduleTask> {

    /**
     * 启动/停用定时任务
     *
     * @param id 任务id
     * @return
     */
    RetMsg updateStatus(String id);
}

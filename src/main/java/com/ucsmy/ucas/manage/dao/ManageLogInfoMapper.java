package com.ucsmy.ucas.manage.dao;

import com.ucsmy.ucas.manage.entity.ManageLogInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * manage_log_info
 * Created by chenqilin on 2017/5/8.
 */
@Mapper
public interface ManageLogInfoMapper {

    /**
     * 添加logInfo
     * @param manageLogInfo
     * @return
     */
    int addManageLogInfo(ManageLogInfo manageLogInfo);
}

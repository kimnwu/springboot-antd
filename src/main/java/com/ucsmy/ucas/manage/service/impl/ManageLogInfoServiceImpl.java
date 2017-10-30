package com.ucsmy.ucas.manage.service.impl;

import com.ucsmy.ucas.manage.dao.ManageLogInfoMapper;
import com.ucsmy.ucas.manage.entity.ManageLogInfo;
import com.ucsmy.ucas.manage.service.ManageLogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenqilin on 2017/5/8.
 */
@Service
public class ManageLogInfoServiceImpl implements ManageLogInfoService {

    @Autowired
    private ManageLogInfoMapper manageLogInfoMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public int addManageLogInfo(ManageLogInfo manageLogInfo) {
        return manageLogInfoMapper.addManageLogInfo(manageLogInfo);
    }
}

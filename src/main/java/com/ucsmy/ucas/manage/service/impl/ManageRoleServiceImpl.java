package com.ucsmy.ucas.manage.service.impl;

import com.ucsmy.ucas.manage.ext.RetMsg;
import org.springframework.stereotype.Service;
import com.ucsmy.ucas.manage.dao.ManageRoleDao;
import com.ucsmy.ucas.manage.entity.ManageRole;
import com.ucsmy.ucas.manage.service.ManageRoleService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManageRoleServiceImpl extends BasicServiceImpl<ManageRole, ManageRoleDao> implements ManageRoleService {

    @Override
    @Transactional
    public RetMsg updateMenu(ManageRole role) {
        dao.updateMenu(role);
        return RetMsg.success("更新权限成功");
    }
}

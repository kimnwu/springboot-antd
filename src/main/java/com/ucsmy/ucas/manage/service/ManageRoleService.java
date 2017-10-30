package com.ucsmy.ucas.manage.service;

import com.ucsmy.commons.service.BasicService;
import com.ucsmy.ucas.manage.entity.ManageRole;
import com.ucsmy.ucas.manage.ext.RetMsg;

public interface ManageRoleService extends BasicService<ManageRole> {
    RetMsg updateMenu(ManageRole role);
}

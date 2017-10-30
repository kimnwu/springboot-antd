package com.ucsmy.ucas.manage.dao;

import com.ucsmy.commons.dao.BasicDao;
import com.ucsmy.ucas.manage.entity.ManageRole;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageRoleDao extends BasicDao<ManageRole> {
    /**
     * 更新菜单
     */
    void updateMenu(ManageRole role);
}

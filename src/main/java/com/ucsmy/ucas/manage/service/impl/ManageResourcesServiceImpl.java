package com.ucsmy.ucas.manage.service.impl;

import com.ucsmy.ucas.manage.dao.ManageResourcesDao;
import com.ucsmy.ucas.manage.entity.ManageResources;
import com.ucsmy.ucas.manage.service.ManageResourcesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageResourcesServiceImpl extends BasicServiceImpl<ManageResources, ManageResourcesDao> implements ManageResourcesService {
    @Override
    @com.ucsmy.commons.log.annotation.Logger(printSQL = true)
    public List<ManageResources> getByMenuId(String menuId) {
        return dao.findByMenuId(menuId);
    }
}

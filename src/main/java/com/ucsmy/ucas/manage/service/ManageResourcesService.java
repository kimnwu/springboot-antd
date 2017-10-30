package com.ucsmy.ucas.manage.service;

import com.ucsmy.commons.service.BasicService;
import com.ucsmy.ucas.manage.entity.ManageResources;

import java.util.List;

public interface ManageResourcesService extends BasicService<ManageResources> {
    List<ManageResources> getByMenuId(String menuId);
}

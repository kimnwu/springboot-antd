package com.ucsmy.ucas.manage.service;

import com.ucsmy.commons.service.BasicService;
import com.ucsmy.ucas.manage.entity.ManageGenCode;
import com.ucsmy.ucas.manage.ext.SelectInfo;

import java.util.List;

public interface ManageGenService extends BasicService<ManageGenCode> {
    List<SelectInfo> getAllTables();
}

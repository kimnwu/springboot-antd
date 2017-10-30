package com.ucsmy.ucas.manage.service.impl;

import com.ucsmy.commons.interceptor.domain.PageInfo;
import com.ucsmy.commons.interceptor.domain.Pageable;
import com.ucsmy.commons.utils.TreeUtils;
import com.ucsmy.ucas.manage.dao.ManageOrganizationDao;
import com.ucsmy.ucas.manage.entity.ManageOrganization;
import com.ucsmy.ucas.manage.ext.AntdPageInfo;
import com.ucsmy.ucas.manage.service.ManageOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ucs_panwenbo on 2017/4/14.
 */
@Service
public class ManageOrganizationServiceImpl extends BasicServiceImpl<ManageOrganization, ManageOrganizationDao> implements ManageOrganizationService {

    @Override
    public List<ManageOrganization> get() {
        return TreeUtils.createTree(super.get());
    }

    @Override
    public PageInfo<ManageOrganization> get(ManageOrganization entity, Pageable pageable) {
        PageInfo<ManageOrganization> info = new AntdPageInfo<>();
        info.setData(TreeUtils.createTree(super.get(entity)));
        return info;
    }

}

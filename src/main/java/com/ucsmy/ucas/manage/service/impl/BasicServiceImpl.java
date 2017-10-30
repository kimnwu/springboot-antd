package com.ucsmy.ucas.manage.service.impl;

import com.ucsmy.commons.bean.BaseNode;
import com.ucsmy.commons.dao.BasicDao;
import com.ucsmy.commons.interceptor.domain.PageInfo;
import com.ucsmy.commons.interceptor.domain.Pageable;
import com.ucsmy.ucas.manage.ext.AntdPageInfo;

public class BasicServiceImpl<E extends BaseNode, D extends BasicDao<E>> extends com.ucsmy.commons.service.BasicServiceImpl<E, D> {

    @Override
    public PageInfo<E> get(E entity, Pageable pageable) {
        return new AntdPageInfo<>(super.get(entity, pageable), pageable);
    }
}

package com.ucsmy.commons.service;

import com.ucsmy.commons.bean.BaseNode;
import com.ucsmy.commons.interceptor.domain.PageInfo;
import com.ucsmy.commons.interceptor.domain.Pageable;
import com.ucsmy.ucas.manage.ext.RetMsg;

import java.util.List;

public interface BasicService<E extends BaseNode> {
    RetMsg save(E entity);

    RetMsg update(E entity);

    RetMsg delete(String id);

    E getById(String id);

    List<E> get();

    List<E> get(E entity);

    PageInfo<E> get(E entity, Pageable pageable);
}

package com.ucsmy.commons.controller;

import com.ucsmy.commons.bean.BaseNode;
import com.ucsmy.commons.interceptor.domain.PageRequest;
import com.ucsmy.commons.service.BasicService;
import com.ucsmy.ucas.manage.ext.RetMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class BasicController<E extends BaseNode, S extends BasicService> {
    @Autowired
    protected S service;

    @PostMapping(value = "save")
    @ResponseBody
    public RetMsg save(@RequestBody E entity) {
        return service.save(entity);
    }

    @PostMapping(value = "update")
    @ResponseBody
    public RetMsg update(@RequestBody E entity) {
        return service.update(entity);
    }

    @DeleteMapping(value = "delete/{id}")
    @ResponseBody
    public RetMsg delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @PostMapping(value = "list")
    @ResponseBody
    public RetMsg find(@RequestBody E entity, PageRequest pageRequest) {
        return RetMsg.success(service.get(entity, pageRequest));
    }
}

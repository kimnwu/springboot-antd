package com.ucsmy.ucas.manage.web;

import com.ucsmy.commons.controller.BasicController;
import com.ucsmy.ucas.manage.entity.ManageGenCode;
import com.ucsmy.ucas.manage.ext.RetMsg;
import com.ucsmy.ucas.manage.service.ManageGenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/gen")
public class ManageGenController extends BasicController<ManageGenCode, ManageGenService> {

    @RequestMapping( value = "getAllTables", method = RequestMethod.POST )
    public RetMsg getAllTables() {
        return RetMsg.success(service.getAllTables());
    }

}

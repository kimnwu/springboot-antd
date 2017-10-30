package com.ucsmy.ucas.manage.web;

import com.ucsmy.commons.controller.BasicController;
import com.ucsmy.ucas.manage.entity.ManageMenu;
import com.ucsmy.ucas.manage.ext.RetMsg;
import com.ucsmy.ucas.manage.service.ManageMenuService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sys/menu")
public class ManageMenuController extends BasicController<ManageMenu, ManageMenuService> {

    @RequestMapping( value = "updateResources", method = RequestMethod.POST )
    public RetMsg updateResources(@RequestBody ManageMenu entity) {
        return service.updateResources(entity);
    }

    @RequestMapping( value = "getRoleMenu/{id}", method = RequestMethod.POST )
    public RetMsg getRoleMenu(@PathVariable("id") String roleId) {
        return RetMsg.success(service.getByRoleId(roleId));
    }

}

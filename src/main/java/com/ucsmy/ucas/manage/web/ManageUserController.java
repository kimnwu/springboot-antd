package com.ucsmy.ucas.manage.web;

import com.ucsmy.commons.controller.BasicController;
import com.ucsmy.commons.utils.RSAUtils;
import com.ucsmy.ucas.manage.entity.ManageUserAccount;
import com.ucsmy.ucas.manage.entity.ManageUserProfile;
import com.ucsmy.ucas.manage.ext.RetMsg;
import com.ucsmy.ucas.manage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ucs_zhongtingyuan on 2017/4/10.
 */
@RestController
@RequestMapping("sys/user")
public class ManageUserController extends BasicController<ManageUserProfile, ManageUserProfileService> {

    @Autowired
    private ManageUserAccountService accountService;

    @RequestMapping( value = "updatePassword", method = RequestMethod.POST )
    public RetMsg updatePassword(@RequestBody ManageUserAccount entity) {
        ManageUserAccount account = accountService.getById(entity.getId());
        if(account == null) {
            return RetMsg.error("用户不存在");
        }
        account.setPassword(RSAUtils.decryptBySession(entity.getPassword()).getData());
        return accountService.updatePassword(account);
    }

    @RequestMapping( value = "shotOff", method = RequestMethod.POST )
    public RetMsg shotOff(@RequestParam String username) {
        return accountService.shotOff(username);
    }

    @RequestMapping( value = "updateStatus/{id}", method = RequestMethod.POST )
    public RetMsg updateStatus(@PathVariable(value = "id") String id) {
        return accountService.updateStatus(id);
    }

}

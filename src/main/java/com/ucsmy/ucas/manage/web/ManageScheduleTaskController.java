package com.ucsmy.ucas.manage.web;

import com.ucsmy.commons.controller.BasicController;
import com.ucsmy.ucas.manage.entity.ManageIpScheduleTask;
import com.ucsmy.ucas.manage.ext.RetMsg;
import com.ucsmy.ucas.manage.service.ManageScheduleTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 定时任务Controller
 * Created by chenqilin on 2017/4/18.
 */
@RestController
@RequestMapping("sys/schedule")
public class ManageScheduleTaskController extends BasicController<ManageIpScheduleTask, ManageScheduleTaskService> {

    @RequestMapping( value = "updateStatus/{id}", method = RequestMethod.POST )
    public RetMsg updateStatus(@PathVariable(value = "id") String id) {
        return service.updateStatus(id);
    }

}

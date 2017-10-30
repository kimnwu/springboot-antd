package com.ucsmy.ucas.manage.service;

import com.ucsmy.commons.service.BasicService;
import com.ucsmy.ucas.manage.entity.ManageMenu;
import com.ucsmy.ucas.manage.ext.RetMsg;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

import java.util.List;

public interface ManageMenuService extends BasicService<ManageMenu> {
    RetMsg updateResources(ManageMenu menu);

    List<ManageMenu> getByRoleId(String roleId);

    /**
     * 初始化SpringSecurity权限数据
     */
    void initSpringSecurityPermission(ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry urlRegistry);
}

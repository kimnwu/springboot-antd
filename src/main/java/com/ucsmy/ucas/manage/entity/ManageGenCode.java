package com.ucsmy.ucas.manage.entity;

import com.ucsmy.commons.bean.BaseNode;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Data
public class ManageGenCode extends BaseNode {
    @NotEmpty(message = "包名不能为空")
    private String packageName;
    @NotEmpty(message = "实体名不能为空")
    private String entityName;
    @NotEmpty(message = "uri不能为空")
    private String uri;
    @NotEmpty(message = "数据库表不能为空")
    private String dataTable;
    private List<ManageGenAttr> attrs;
}

package ${code.packageName}.entity;

import com.ucsmy.commons.bean.BaseNode;
import lombok.Data;

@Data
public class ${code.entityName} extends BaseNode {
<#list code.attrs as attr>
    <#if attr.javaName != "id">private ${attr.javaType} ${attr.javaName};// ${attr.des}</#if>
</#list>
}
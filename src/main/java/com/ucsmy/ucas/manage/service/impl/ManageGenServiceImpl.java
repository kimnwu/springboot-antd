package com.ucsmy.ucas.manage.service.impl;

import com.ucsmy.commons.utils.GenUtils;
import com.ucsmy.commons.utils.StringUtils;
import com.ucsmy.ucas.config.exception.ServiceException;
import com.ucsmy.ucas.config.properties.UcsmyProperties;
import com.ucsmy.ucas.manage.dao.ManageGenAttrDao;
import com.ucsmy.ucas.manage.dao.ManageGenCodeDao;
import com.ucsmy.ucas.manage.entity.ManageGenAttr;
import com.ucsmy.ucas.manage.entity.ManageGenCode;
import com.ucsmy.ucas.manage.ext.RetMsg;
import com.ucsmy.ucas.manage.ext.SelectInfo;
import com.ucsmy.ucas.manage.service.ManageGenService;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;
import org.mybatis.generator.internal.util.JavaBeansUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class ManageGenServiceImpl extends BasicServiceImpl<ManageGenCode, ManageGenCodeDao> implements ManageGenService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ManageGenAttrDao genAttrDao;

    @Autowired
    private DataSourceProperties properties;

    @Autowired
    private UcsmyProperties ucsmyProperties;

    @Override
    protected RetMsg saveHandle(ManageGenCode entity) {
        RetMsg retMsg = super.saveHandle(entity);// 生成ID,并返回

        if(!dao.findAllTables().contains(entity.getDataTable())) {
            return RetMsg.error("数据库表不存在");
        }

        GenUtils.getTableColumns(dataSource, getDatabase(), entity).forEach(attr -> {
            if(genAttrDao.save(attr) == 0) {
                throw new ServiceException("表属性无法插入");
            }
        });

        return retMsg;
    }

    @Override
    public List<SelectInfo> getAllTables() {
        List<SelectInfo> selects = new ArrayList<>();
        dao.findAllTables().forEach(t -> selects.add(SelectInfo.builder().id(t).name(t).build()));
        return selects;
    }

    @Override
    @Transactional
    public RetMsg update(ManageGenCode entity) {
        if(entity.getAttrs() != null) {
            entity.getAttrs().forEach(attr -> genAttrDao.update(attr));
        }

        RetMsg retMsg = super.update(entity);

        if(ucsmyProperties.isGenCode()) {// 代码生成
            ManageGenCode code = this.getById(entity.getId());
            code.getAttrs().sort(Comparator.comparingInt(ManageGenAttr::getWeight));
            GenUtils.genCode(code);
        }

        return retMsg;
    }

    @Override
    protected RetMsg deleteHandle(ManageGenCode databaseEntity) {
        if(databaseEntity.getAttrs() != null) {
            databaseEntity.getAttrs().forEach(attr -> genAttrDao.delete(attr.getId()));
        }
        return super.deleteHandle(databaseEntity);
    }

    private String getDatabase() {
        String driverClassName = properties.getUrl();
        int beginIndex = driverClassName.lastIndexOf('/') + 1;
        int endIndex = driverClassName.lastIndexOf('?');
        return driverClassName.substring(beginIndex, endIndex == -1 ? driverClassName.length() : endIndex);
    }
}

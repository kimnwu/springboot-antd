package com.ucsmy.ucas.manage.dao;

import com.ucsmy.commons.dao.BasicDao;
import com.ucsmy.ucas.manage.entity.ManageGenCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ManageGenCodeDao extends BasicDao<ManageGenCode> {
    // 查询当前数据库所有的表
    List<String> findAllTables();
}

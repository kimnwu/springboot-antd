package com.ucsmy.ucas.manage.dao;

import com.ucsmy.commons.dao.BasicDao;
import com.ucsmy.ucas.manage.entity.ManageUserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface ManageUserAccountDao extends BasicDao<ManageUserAccount> {

	int updatePassword(ManageUserAccount account);

	int updateStatus(@Param("id") String id);

	ManageUserAccount findByUserName(@Param("userName") String userName);

}

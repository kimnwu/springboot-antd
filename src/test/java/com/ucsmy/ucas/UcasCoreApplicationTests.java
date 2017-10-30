package com.ucsmy.ucas;

import com.ucsmy.ucas.manage.dao.ManageResourcesDao;
import com.ucsmy.ucas.manage.entity.ManageResources;
import com.ucsmy.ucas.manage.service.ManageResourcesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UcasCoreApplicationTests {

	@Autowired
	private ManageResourcesService service;

	@Test
	public void test() {
		//resourcesDao.findById("1");
		service.getById("1");
	}

}

package springboot.yang.springboot.test;


import java.util.concurrent.FutureTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.yang.springboot.SpringBootWebApplication;
import springboot.yang.springboot.config.CommonUrlConfigScan;


@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@ActiveProfiles(value = "dev")
public class EnvironmentConfigurationTest {
	
	 Logger logger = LoggerFactory.getLogger(EnvironmentConfigurationTest.class);

	@Autowired
	private CommonUrlConfigScan commonUrlConfigScan;
	
	@Test
	public void test01() throws Exception {
//		System.out.println(commonUrlConfigScan);
		logger.info("名称：{}，测试结果{}。",this.getClass().getName(),commonUrlConfigScan.toString());
		
	}

	
	
}

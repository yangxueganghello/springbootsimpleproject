package springboot.yang.springboot.test;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
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
@Slf4j
public class EnvironmentLoggerConfigurationTest {
	@Autowired
	private CommonUrlConfigScan commonUrlConfigScan;
	
	@Test
	public void test01() throws Exception {
//		System.out.println(commonUrlConfigScan);
		log.info("名称：{}，测试结果{}。",this.getClass().getName(),commonUrlConfigScan.toString());
	}
}

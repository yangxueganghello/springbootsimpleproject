package springboot.yang.springboot.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.yang.springboot.annotation.Query;
import springboot.yang.springboot.config.CommonUrlConfigScan;
import springboot.yang.springboot.entities.Dept;
import springboot.yang.springboot.handler.AbstractHandler;
import springboot.yang.springboot.handler.BeanTool;
import springboot.yang.springboot.handler.HandlerContext;
import springboot.yang.springboot.manager.DeptManager;
import springboot.yang.springboot.service.DeptService;

/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 */
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
	
/*  @Value("#{'${configonetemp}'}")
  private String configone;
  @Value("#{'${configtwotemp}'}")
  private String configtwo;
  @Value("#{'${configthreetemp}'}")
  private String configthree;
  
  @Value("#{'${configthreetemptest}'}")
  private String configfour;*/

	@Autowired
	private CommonUrlConfigScan commonUrlConfigScan;
	
	@Autowired
	private DeptManager deptManager;
	
    @Autowired
    private HandlerContext handlerContext;
    
	@Override
	public void addDebt(Dept dept) {
		deptManager.addDept(dept);
	}
	
	@Query
	@Override
	public Object fetDeptList(Dept dept) {
		return deptManager.fetDeptList(dept);
	}

	@Override
	public void operatePluin(String operateType) {
		Class<? extends AbstractHandler> abstractHandlerClass = handlerContext.getInstance(operateType);
		AbstractHandler abstractHandler = BeanTool.getBean(abstractHandlerClass);
		String str = abstractHandler.incrGift("就是传入一个参数");
		System.out.println(str);
	}

	@Override
	public void fetchConfig() {
		/*System.out.println("configone  :  "+configone);
		System.out.println("configtwo  :  "+configtwo);
		System.out.println("configthree  :  "+configthree);
		System.out.println("configfour  :  "+configfour);*/
		log.info("你看看mdc以及多环境下的配置都进来了:{}",commonUrlConfigScan);
		log.debug("你看看mdc以及多环境下的配置都进来了:{}",commonUrlConfigScan);
		log.error("你看看mdc以及多环境下的配置都进来了:{}",commonUrlConfigScan);
	}

}

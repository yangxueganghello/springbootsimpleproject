package springboot.yang.springboot.controller;

import java.util.ArrayList;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.yang.springboot.entities.Dept;
import springboot.yang.springboot.service.DeptService;
import springboot.yang.springboot.utils.ReturnUtil;
import springboot.yang.springboot.vo.ReturnVo;

/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 */
@RestController
@RequestMapping(value = "/yang")
@Slf4j
public class DepterController {

	@Autowired
	private DeptService deptService;

	@RequestMapping(value = "/consumer/dept/add")
	public Object add(Model model) {
		Dept dept = Dept.builder()
						.dname("自测1")
						.db_source("product")
						.build();
		deptService.addDebt(dept);
		model.addAttribute("yes");
		return "yes";
	}
	
	@RequestMapping(value = "/consumer/dept/fetch" , method = RequestMethod.GET)
	public Object fechDept(@RequestParam(value = "dname", required = false) String dname) {
		Objects.requireNonNull(dname, "数据不可为null");
		Dept dept = Dept.builder()
				.dname("自测1")
				.build();
		Object deptList = Lists.newArrayList();
		deptList = deptService.fetDeptList(dept);
		return deptList;
	}
	
	/**
	 * 重要  重要
	 */
	@RequestMapping(value = "/operateType/{operateType}" , method = RequestMethod.GET)
	public Object operatePluin(@PathVariable("operateType") String operateType){
		deptService.operatePluin(operateType);
		return null;
	}	                      
	
	
	/**
	 * 
	 */
	@RequestMapping(value = "/fetchConfig/" , method = RequestMethod.GET)
	public Object fetchConfig()
	{
		log.info("测试1 start");
		deptService.fetchConfig();
		log.info("测试1 end");
		return ReturnUtil.success("ok");
	}
}

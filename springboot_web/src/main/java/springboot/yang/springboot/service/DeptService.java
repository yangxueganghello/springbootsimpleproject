package springboot.yang.springboot.service;

import java.util.List;

import springboot.yang.springboot.entities.Dept;

/**
 * 
 * @author yangxuegang
 * 2019年8月28日
 */
public interface DeptService {

	void addDebt(Dept dept);

	Object fetDeptList(Dept dept);

	void operatePluin(String operateType);

	void fetchConfig();

}

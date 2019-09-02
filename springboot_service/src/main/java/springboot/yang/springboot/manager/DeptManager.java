package springboot.yang.springboot.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springboot.yang.springboot.entities.Dept;
import springboot.yang.springboot.mapper.DeptMapper;

/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 */
@Repository
@Transactional(readOnly = true)
public class DeptManager {
	
	@Autowired
	private DeptMapper deptMapper;
	
	//封装查询参数
	@Transactional(readOnly = false)
	public void addDept (Dept  dept){
		deptMapper.addDept(dept);
	}

	public List<Dept> fetDeptList(Dept dept) {
		return deptMapper.fetDeptList(dept);
	}

}

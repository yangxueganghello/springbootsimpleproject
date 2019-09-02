package springboot.yang.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springboot.yang.springboot.entities.Dept;

/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 */
@Mapper
public interface DeptMapper {
	
	  public boolean addDept(Dept dept);
	  
	  public Dept findById(Long id);
	 
	  public List<Dept> findAll();

	  public List<Dept> fetDeptList(Dept dept);

}

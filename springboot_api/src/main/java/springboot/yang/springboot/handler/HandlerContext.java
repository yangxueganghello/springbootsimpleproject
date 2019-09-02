package springboot.yang.springboot.handler;

import java.util.Map;
import java.util.Objects;


import springboot.yang.springboot.enums.OperateType;

/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 * @param <T>
 */
public class HandlerContext {
	
	private Map<Enum<?>, Class<? extends AbstractHandler>> handlerMap;
	
	public HandlerContext(Map<Enum<?>, Class<? extends AbstractHandler>> handlerMap) {
		this.handlerMap = handlerMap;
	}
	
	public  Class<? extends AbstractHandler> getInstance(String operateType){
		//获取需要执行类的Class
//		OperateType enumType = OperateType.getEnumType(Ints.tryParse(operateType));
		OperateType operateTypeEnum = OperateType.getEnumType(operateType);
		Class<? extends AbstractHandler> clazz = handlerMap.get(operateTypeEnum);
		if (Objects.isNull(clazz))
			throw new IllegalArgumentException("未知积分类型:"+operateTypeEnum);
		return clazz;
	}

}

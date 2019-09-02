package springboot.yang.springboot.strategy;

import org.springframework.stereotype.Component;

import springboot.yang.springboot.annotation.OperateAnnotation;
import springboot.yang.springboot.enums.OperateType;
import springboot.yang.springboot.handler.AbstractHandler;

/**
 * 
 * @author yangxuegang
 * 2019年8月28日
 */
@Component
@OperateAnnotation(values={OperateType.OperateType3,OperateType.OperateType4})
public class OperateThree extends AbstractHandler{

	@Override
	public <T, V> V incrGift(T t) {
		System.out.println(this.getClass().getName() +" is running incrGift");
		return (V)t;
	}

	@Override
	public <T, V> V subGift(T t) {
		System.out.println(this.getClass().getName() +" is running subGift");
		return (V)t;
	}

}

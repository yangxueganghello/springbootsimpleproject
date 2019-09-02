package springboot.yang.springboot.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import springboot.yang.springboot.enums.OperateType;


/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateAnnotation {
	OperateType[] values();
}

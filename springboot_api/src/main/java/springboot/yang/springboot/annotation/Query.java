package springboot.yang.springboot.annotation;

import java.lang.annotation.*;

/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Query {
}

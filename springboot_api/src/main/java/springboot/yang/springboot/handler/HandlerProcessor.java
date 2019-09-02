package springboot.yang.springboot.handler;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import springboot.yang.springboot.annotation.OperateAnnotation;
import springboot.yang.springboot.enums.OperateType;

import com.google.common.collect.Maps;
/**
 * 
 * @author yangxuegang
 * 2019年8月28日
 */
@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {
	
	private static final String HANDLER_URL="springboot.yang.springboot.strategy";

	@SuppressWarnings("unchecked")
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		Map<Enum<?>, Class<? extends AbstractHandler>> handlerMap=Maps.newHashMapWithExpectedSize(3);
		ClassScaner.scan(HANDLER_URL, OperateAnnotation.class)
					.stream()
					.forEach(clazz -> {
						Enum<OperateType>[] values = clazz.getAnnotation(OperateAnnotation.class).values();
						for (Enum<OperateType> enumItem : values) 
							handlerMap.put(enumItem, (Class<? extends AbstractHandler>)clazz);
					});
		HandlerContext handlerContext=new HandlerContext(handlerMap);
		beanFactory.registerSingleton(HandlerContext.class.getName(), handlerContext);
	}

}

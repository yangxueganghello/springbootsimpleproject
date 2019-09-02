package springboot.yang.springboot.mdc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 注册拦截器
 * WEB MVC配置类
 * @author yangxuegang
 * 2019年8月30日
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{

	/**
	 * 把拦截器注入为bean
	 * @return
	 */
	@Bean
	public HandlerInterceptorAdapter logInterceptor(){
		return new LogInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//addPathPatterns 用于添加拦截规则，这里假设拦截/url后面的全部链接
		//excludePathPatterns用户排除拦截
		registry.addInterceptor(logInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
	
}

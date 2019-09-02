package springboot.yang.springboot.mdc;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 日志拦截器组件，在输出日志上加上sesssionId
 * @author yangxuegang
 * 2019年8月30日
 */
public class LogInterceptor extends HandlerInterceptorAdapter{
	
	private final static String SESSION_KEY="sessionId";
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//删除SessionId
		MDC.remove(SESSION_KEY);
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		 // 设置SessionId
        String token = UUID.randomUUID().toString().replace("-", "");
        MDC.put(SESSION_KEY, token);
		return true;
	}

}

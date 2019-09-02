package springboot.yang.springboot.handler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;


/**				
 * 
 * @author yangxuegang
 * 2019年8月27日
 */
@Component
public class BeanTool extends ApplicationObjectSupport implements ApplicationContextAware{
    static ApplicationContext context;
    private static ApplicationContext applicationContext = null;

//    public static void setApplicationContext(WebApplicationContext applicationContext) {
//        BeanTool.applicationContext = applicationContext;
//    }

    public BeanTool getInstance() {
        return new BeanTool();
    }

    protected void initApplicationContext(ApplicationContext context) {
        super.initApplicationContext(context);
        if (applicationContext == null) {
            applicationContext = context;
        }
    }

    public static ApplicationContext getAppContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return getAppContext().getBean(name);
    }

//    public static Object getBean(Class clazz) {
//        return getAppContext().getBean(clazz);
//    }
    public static <T> T getBean(Class<T> clazz) {
    	return getAppContext().getBean(clazz);
    }
}
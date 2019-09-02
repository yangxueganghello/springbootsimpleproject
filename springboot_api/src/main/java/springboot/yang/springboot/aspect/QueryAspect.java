package springboot.yang.springboot.aspect;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import springboot.yang.springboot.enums.ReturnCode;
import springboot.yang.springboot.vo.ReturnVo;

/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class QueryAspect {

    @Pointcut("@annotation(springboot.yang.springboot.annotation.Query)")
    public void query() {
    }

    @Around("query()")
    public Object wrapperQuery(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        log.info("添加分页参数开始");
        if (args != null && args.length >= 2) {
//            if (args[0] instanceof QueryPara) {	
//                QueryPara queryDto = (QueryPara) args[0];
//                wrapPage(queryDto, args);
//            }
        }
        ReturnVo vo = new ReturnVo(ReturnCode.SUCCESS);	
        vo.setData(jp.proceed(args));
        return vo;
    }

  /*  private void wrapPage(QueryPara queryDto, Object[] args) {
        if (args.length >= 2 && Boolean.TRUE == queryDto.getPaging() && args[1] instanceof IPage) {
            Page page = (Page) args[1];
            if (queryDto.getCurrentPage() > 0) {
                page.setCurrent(queryDto.getCurrentPage());
            }
            if (queryDto.getPageSize() > 0) {
                page.setSize(queryDto.getPageSize());
            }
            page.setOptimizeCountSql(false);
            page.setSearchCount(false);
        }
    }*/
}

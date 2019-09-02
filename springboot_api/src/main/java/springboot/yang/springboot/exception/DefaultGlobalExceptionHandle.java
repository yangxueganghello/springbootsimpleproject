package springboot.yang.springboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import springboot.yang.springboot.enums.ReturnCode;
import springboot.yang.springboot.utils.ReturnUtil;
import springboot.yang.springboot.vo.ReturnVo;

/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 */
@RestControllerAdvice
public class DefaultGlobalExceptionHandle {

    private Logger logger = LoggerFactory.getLogger(DefaultGlobalExceptionHandle.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ReturnVo handle(Exception e) {
        ReturnCode returnCode = ReturnCode.ERROR;
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            returnCode = businessException.getReturnCode();
            logger.error("业务异常！异常信息：{}", returnCode.getMsg());
        } else {
            logger.error("异常信息：{}", e.getMessage());
            e.printStackTrace();
        }
        return ReturnUtil.error(returnCode);
    }
}

package springboot.yang.springboot.utils;

import springboot.yang.springboot.enums.ReturnCode;
import springboot.yang.springboot.vo.ReturnVo;

/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 */
public class ReturnUtil {

    public static <T> ReturnVo success(T t){
        return new ReturnVo(ReturnCode.SUCCESS, t);
    }

    public static ReturnVo success(){
        return success(null);
    }

    public static ReturnVo error(){
        return new ReturnVo(ReturnCode.ERROR);
    }

    public static ReturnVo error(ReturnCode returnCode){
        return new ReturnVo(returnCode);
    }

    public static <T> ReturnVo error(T t){
        return new ReturnVo(ReturnCode.BUSSINESS_ERROR, t);
    }
}

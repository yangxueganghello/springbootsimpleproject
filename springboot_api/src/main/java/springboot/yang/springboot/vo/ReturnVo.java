package springboot.yang.springboot.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.yang.springboot.enums.ReturnCode;


/**
 * 统一返回类型
 * @author yangxuegang
 * 2019年8月27日
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReturnVo<T> {
    private String code;  //响应码
    private String msg;   //响应描述
    private T data;  //响应内容
    
    public ReturnVo(ReturnCode returnCode){
        this.code = returnCode.getCode();
        this.msg = returnCode.getMsg();
    }

    public ReturnVo(ReturnCode returnCode, T data){
        this.code = returnCode.getCode();
        this.msg = returnCode.getMsg();
        this.data = data;
    }
}

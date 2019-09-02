package springboot.yang.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.yang.springboot.enums.ReturnCode;

/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessException extends RuntimeException {
    private ReturnCode returnCode;

    public BusinessException(String msg){
    	super(msg);
    }
    
    
}   
    
    

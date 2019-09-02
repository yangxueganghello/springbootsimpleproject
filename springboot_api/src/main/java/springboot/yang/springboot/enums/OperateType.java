package springboot.yang.springboot.enums;

import java.util.Optional;

import org.springframework.util.StringUtils;



/**
 * 操作类型
 * @author yangxuegang
 * 2019年8月27日
 */
public enum OperateType {

	OperateType1("operateType1", "操作类型1"),
	OperateType2("operateType2", "操作类型2"),
	OperateType3("operateType3", "操作类型3"),
	OperateType4("operateType4", "操作类型4"),
	OperateType5("operateType5", "操作类型5"),
	OperateType6("operateType6", "操作类型6"),
	OperateType7("operateType7", "操作类型7"),
	OperateType8("operateType8", "操作类型8");
 

    private String code;
    private String msg;

    OperateType(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public static OperateType getEnumType(String operateType){
    	if (StringUtils.isEmpty(operateType))return null;
    	for (OperateType operateTypeEnum : OperateType.values())
			if (operateTypeEnum.code.equals(operateType)) return operateTypeEnum;
    	return null;
    }
 }

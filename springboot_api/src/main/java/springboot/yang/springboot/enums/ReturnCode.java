package springboot.yang.springboot.enums;


/**
 * 统一返回状态码
 * @author yangxuegang
 * 2019年8月27日
 */
public enum ReturnCode {

    SUCCESS("0000", "请求成功"),
    ERROR("1111", "请求失败"),
    SYSTEM_ERROR("1000", "系统异常"),
    PARAM_ERROR("2002", "参数错误"),
    BUSSINESS_ERROR("2001", "业务逻辑错误");

    private String code;
    private String msg;

    ReturnCode(String code, String msg){
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
    }}

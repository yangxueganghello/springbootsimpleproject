package springboot.yang.springboot.exception;

/** Created by yangyi on 2019/6/4. */
public enum ErrorCode {
  SERVER_EXCEPTION("SERVER_EXCEPTION", "服务器发生异常，请稍后重试！"),
  OUT_OF_INT_MAX_EXCEPTION("OUT_OF_INT_MAX_EXCEPTION", "超出最大值"),
  GLOBAL_EXCEPTION("GLOBAL_EXCEPTION", "参数不正确"),
  E000001("E000001", "缺少必要参数"),
  E000002("E000002", "参数为空异常"),
  E000003("E000003", "参数错误异常"),
  E000004("E000004", "额度不足异常"),
  E000005("E000005", "不在时间范围异常"),
  E000006("E000006", "重复提交异常"),
  E000007("E000007", "数据配置异常"),
  E_401("401", "账号或密码错误"),
  E_500("500", "请求方式有误,请检查 GET/POST"),
  E_502("502", "权限不足"),
  E_20011("20011", "登陆已过期,请重新登陆");

  private String value;
  private String desc;

  private ErrorCode(String value, String desc) {
    this.setValue(value);
    this.setDesc(desc);
  }

  /**
   * Getter for the field <code>value</code>.
   *
   * @return a {@link java.lang.String} object.
   */
  public String getValue() {
    return this.value;
  }

  /**
   * Setter for the field <code>value</code>.
   *
   * @param value a {@link java.lang.String} object.
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Getter for the field <code>desc</code>.
   *
   * @return a {@link java.lang.String} object.
   */
  public String getDesc() {
    return this.desc;
  }

  /**
   * Setter for the field <code>desc</code>.
   *
   * @param desc a {@link java.lang.String} object.
   */
  public void setDesc(String desc) {
    this.desc = desc;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "[" + this.value + "]" + this.desc;
  }
}

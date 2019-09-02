/*package springboot.yang.springboot.utils;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.StringUtils;

import springboot.yang.springboot.exception.BusinessException;
import springboot.yang.springboot.exception.ErrorCode;

*//**
 * Created by yangyi on 2019/6/4.
 *
 * @author swearwang
 * @version $Id: $Id
 *//*
public class ServiceValidate {

  private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "服务器参数校验异常--判断条件是false";

  private static final String DEFAULT_IS_NULL_EX_MESSAGE = "服务器参数校验异常--对象为null";

  private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "服务器参数校验异常--数组为空";

  private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "服务器参数校验异常--集合为空";

  private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "服务器参数校验异常--参数为空";

  private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "服务器参数校验异常--参数为空";

  *//** Constructor. This class should not normally be instantiated. *//*
  public ServiceValidate() {
    super();
  }

  *//**
   * Assert true.
   *
   * @param expression expression
   * @param message message
   * @throws BusinessException BusinessException
   *//*
  public static void isTrue(boolean expression, String message) {
    if (expression == false) {
      throw new BusinessException(message);
    }
  }

  *//**
   * Assert true.
   *
   * @param expression expression
   * @param errorCode errorCode
   * @throws BusinessException BusinessException
   *//*
  public static void isTrue(boolean expression, ErrorCode errorCode) {
    if (expression == false) {
      throw new BusinessException(errorCode.getValue(), errorCode.getDesc());
    }
  }

  *//**
   * Assert true.
   *
   * @param expression expression
   * @param message message
   * @param args args
   * @throws BusinessException BusinessException
   *//*
  public static void isTrue(boolean expression, String message, Object... args) {
    if (expression == false) {
      throw new BusinessException(message, args);
    }
  }

  *//**
   * Assert true.
   *
   * @param expression expression
   * @throws BusinessException BusinessException
   *//*
  public static void isTrue(boolean expression) {
    if (expression == false) {
      throw new BusinessException(DEFAULT_IS_TRUE_EX_MESSAGE);
    }
  }

  *//**
   * Assert notNull.
   *
   * @param object object
   * @param <T> Class T
   * @return a T object.
   *//*
  public static <T> T notNull(T object) {
    return notNull(object, DEFAULT_IS_NULL_EX_MESSAGE);
  }

  *//**
   * Assert notNull.
   *
   * @param object object
   * @param errorCode errorCode
   * @param <T> Class T
   * @return a T object.
   *//*
  public static <T> T notNull(T object, ErrorCode errorCode) {
    if (object == null) {
      throw new BusinessException(errorCode.getValue(), errorCode.getDesc());
    }
    return object;
  }

  *//**
   * Assert notNull.
   *
   * @param object object
   * @param message message
   * @param <T> T
   * @return a T object.
   *//*
  public static <T> T notNull(T object, String message) {
    if (object == null) {
      throw new BusinessException(message);
    }
    return object;
  }

  *//**
   * Assert notNull.
   *
   * @param array array
   * @param message message
   * @param <T> T
   * @return an array of T[] objects.
   *//*
  public static <T> T[] notEmpty(T[] array, String message) {
    if (array == null) {
      throw new BusinessException(message);
    }
    if (array.length == 0) {
      throw new BusinessException(message);
    }
    return array;
  }

  *//**
   * Assert notNull.
   *
   * @param array array
   * @param <T> T
   * @return an array of T[] objects.
   *//*
  public static <T> T[] notEmpty(T[] array) {
    return notEmpty(array, DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE);
  }

  *//**
   * Assert notNull.
   *
   * @param collection collection
   * @param message message
   * @return a T object.
   *//*
  public static <T extends Collection<?>> T notEmpty(T collection, String message) {
    if (collection == null || collection.isEmpty()) {
      throw new BusinessException(message);
    }
    return collection;
  }

  *//**
   * Assert notNull.
   *
   * @param collection collection
   * @return a T object.
   *//*
  public static <T extends Collection<?>> T notEmpty(T collection) {
    return notEmpty(collection, DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE);
  }

  *//**
   * Assert notNull.
   *
   * @param map map
   * @param message message
   * @return a T object.
   *//*
  public static <T extends Map<?, ?>> T notEmpty(T map, String message) {
    if (map == null) {
      throw new BusinessException(message);
    }
    if (map.isEmpty()) {
      throw new BusinessException(message);
    }
    return map;
  }

  *//**
   * Assert notNull.
   *
   * @param map map
   * @param errorCode errorCode
   * @return a T object.
   *//*
  public static <T extends Map<?, ?>> T notEmpty(T map, ErrorCode errorCode) {
    if (map == null || map.isEmpty()) {
      throw new BusinessException(errorCode.getValue(), errorCode.getDesc());
    }
    return map;
  }

  *//**
   * Assert notNull.
   *
   * @param map map
   * @return a T object.
   *//*
  public static <T extends Map<?, ?>> T notEmpty(T map) {
    return notEmpty(map, DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE);
  }

  *//**
   * Assert notNull.
   *
   * @param chars chars
   * @param message message
   * @return a T object.
   *//*
  public static <T extends CharSequence> T notEmpty(T chars, String message) {
    if (chars == null) {
      throw new BusinessException(message);
    }
    if (chars.length() == 0) {
      throw new BusinessException(message);
    }
    return chars;
  }

  *//**
   * Assert notNull.
   *
   * @param chars chars
   * @param message message
   * @return a T object.
   *//*
  public static <T extends CharSequence> T notBlank(T chars, String message) {
    if (chars == null) {
      throw new BusinessException(message);
    }
    if (StringUtils.isBlank(chars)) {
      throw new BusinessException(message);
    }
    return chars;
  }

  *//**
   * Assert notNull.
   *
   * @param chars chars
   * @param errorCode errorCode
   * @return a T object.
   *//*
  public static <T extends CharSequence> T notBlank(T chars, ErrorCode errorCode) {
    if (chars == null || StringUtils.isBlank(chars)) {
      throw new BusinessException(errorCode.getValue(), errorCode.getDesc());
    }
    return chars;
  }

  *//**
   * Assert notNull.
   *
   * @param chars chars
   * @param message message
   * @param args args
   * @return a T object.
   *//*
  public static <T extends CharSequence> T notBlank(T chars, String message, Object... args) {
    if (chars == null) {
      throw new BusinessException(message, args);
    }
    if (StringUtils.isBlank(chars)) {
      throw new BusinessException(message, args);
    }
    return chars;
  }

  *//**
   * Assert notNull.
   *
   * @param chars chars
   * @return a T object.
   *//*
  public static <T extends CharSequence> T notBlank(T chars) {
    return notBlank(chars, DEFAULT_NOT_BLANK_EX_MESSAGE);
  }

  *//**
   * @param object object
   * @param message message
   * @return a T object.
   *//*
  public static <T> T isEmpty(T object, String message) {
    if (org.springframework.util.StringUtils.isEmpty(object)) {
      throw new BusinessException(ReturnState.FAILED, message);
    }
    return object;
  }
}
*/
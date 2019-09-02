package springboot.yang.springboot.handler;


/**
 * 
 * @author yangxuegang
 * 2019年8月27日
 * @param <T>
 * @param <V>
 */
public abstract class AbstractHandler {
	abstract public <T,V> V incrGift(T t);
	
	abstract public<T,V> V subGift(T t);
}

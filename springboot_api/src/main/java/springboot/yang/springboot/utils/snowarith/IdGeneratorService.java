package springboot.yang.springboot.utils.snowarith;

/**
 * Created by yangyi on 2018/3/15.
 *
 * @author swearwang
 * @version $Id: $Id
 */
public interface IdGeneratorService {

  /**
   * nextId.
   *
   * @return a long.
   */
  long nextId();

  /**
   * state.
   *
   * @return a {@link String} object.
   */
  String state();
}

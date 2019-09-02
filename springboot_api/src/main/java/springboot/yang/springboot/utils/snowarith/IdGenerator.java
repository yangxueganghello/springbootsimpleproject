package springboot.yang.springboot.utils.snowarith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yangyi on 2018/3/15.
 *
 * @author swearwang
 * @version $Id: $Id
 */
@Component
public class IdGenerator {

  @Autowired private IdGeneratorFactory idGeneratorFactory;

  /**
   * nextId.
   *
   * @return a {@link String} object.
   */
  public String nextId() {
    return idGeneratorFactory.getInstance().nextId() + "";
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return idGeneratorFactory.getInstance().state();
  }
}

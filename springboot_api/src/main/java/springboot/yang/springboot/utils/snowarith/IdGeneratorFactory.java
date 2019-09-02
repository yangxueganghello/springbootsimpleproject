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
public class IdGeneratorFactory {

  @Autowired private IdGeneratorService instance;

  private IdGeneratorFactory() {}

  // @PostConstruct
  // public void init() throws ClassNotFoundException {
  // Class<IdGeneratorService> clazz = (Class<IdGeneratorService>)
  // Class.forName(handleClass);
  // ApplicationContext appContext = SpringContextHolder.getApplicationContext();
  // IdGeneratorService instance = appContext.getBean(clazz);
  // }

  /** Getter for the field <code>instance</code>. */
  public IdGeneratorService getInstance() {
    return instance;
  }
}

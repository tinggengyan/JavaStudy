package processor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by yantinggeng on 2016/11/9.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RuntimeAnnotation {

    String name();

}

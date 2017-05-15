package mode;

import java.lang.annotation.*;

/**
 * create in CreateMode
 * Created by dy on 2017/5/15.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CreateIn {

    CreateMode value() default CreateMode.EPHEMERAL;

}

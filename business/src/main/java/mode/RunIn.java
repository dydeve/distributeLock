package mode;

import java.lang.annotation.*;

/**
 * runtime
 * Created by dy on 2017/5/15.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RunIn {

    RunMode value() default RunMode.APPLICATION;

    enum RunMode {
        APPLICATION,
        CLUSTER
    }

}

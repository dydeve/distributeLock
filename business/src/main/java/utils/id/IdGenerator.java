package utils.id;

import mode.RunIn;

/**
 * an id generator
 * Created by dy on 2017/5/14.
 */
@RunIn(RunIn.RunMode.APPLICATION)
public interface IdGenerator<T> {

    /**
     * generate id
     * @return
     */
    T id();

}

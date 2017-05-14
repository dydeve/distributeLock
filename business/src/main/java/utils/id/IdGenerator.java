package utils.id;

/**
 * an id generator
 * Created by dy on 2017/5/14.
 */
public interface IdGenerator<T> {

    /**
     * generate id
     * @return
     */
    T id();

}

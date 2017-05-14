package utils.id;

/**
 * a distributed id generator
 * Created by dy on 2017/5/15.
 */
public interface DistributedIdGenerator<T> {

    T distributedId();

}

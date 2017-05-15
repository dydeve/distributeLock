package utils.id;

import mode.RunIn;

/**
 * a distributed id generator
 * Created by dy on 2017/5/15.
 */
@RunIn(RunIn.RunMode.CLUSTER)
public interface DistributedIdGenerator<T> extends IdGenerator<T> {

}

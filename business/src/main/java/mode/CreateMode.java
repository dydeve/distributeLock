package mode;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @see org.apache.zookeeper.CreateMode
 * Created by dy on 2017/5/15.
 */
public class CreateMode {

    public static final BiMap<Integer, CreateMode> biMap = HashBiMap.create();


    private final int flag;
    private final boolean ephemeral;
    private final boolean sequential;


    public CreateMode(int flag, boolean ephemeral, boolean sequential) {
        this.flag = flag;
        this.ephemeral = ephemeral;
        this.sequential = sequential;
    }

    public int toFlag() {
        return flag;
    }

    public boolean isEphemeral() {
        return ephemeral;
    }

    public boolean isSequential() {
        return sequential;
    }

    static public CreateMode fromFlag(int flag) {

    }


    static public CreateMode fromFlagOrDefault(int flag, CreateMode defaultMode) {

    }
}

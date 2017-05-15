package mode;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import java.util.EnumSet;
import java.util.Map;

/**
 * @see org.apache.zookeeper.CreateMode
 * Created by dy on 2017/5/15.
 */
public enum CreateMode {


    PERSISTENT(0, false, false),

    EPHEMERAL(1, true, false),

    PERSISTENT_SEQUENTIAL(2, false, true),

    EPHEMERAL_SEQUENTIAL(3, true, true);

    private static final Map<Integer, CreateMode> map = Maps.newHashMapWithExpectedSize(CreateMode.values().length);

    static {
        EnumSet.allOf(CreateMode.class).forEach(cm -> map.put(cm.flag, cm));
    }

    private final int flag;

    /**
     * 临时/持久化
     */
    private final boolean ephemeral;

    /**
     * 有序/无序
     */
    private final boolean sequential;


    CreateMode(int flag, boolean ephemeral, boolean sequential) {
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
        return map.get(flag);
    }


    static public CreateMode fromFlagOrDefault(int flag, CreateMode defaultMode) {
        return map.getOrDefault(flag, defaultMode);
    }
}

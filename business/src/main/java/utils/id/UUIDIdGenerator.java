package utils.id;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by dy on 2017/5/14.
 */
public class UUIDIdGenerator implements IdGenerator<String> {

    //save strongId
    private static final ConcurrentMap<String, Thread> strongIdHolder = new ConcurrentHashMap<>();

    @Override
    public String id() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String strongId() {
        String id = id();
        if (strongIdHolder.putIfAbsent(id, Thread.currentThread()) != null) {
            strongId();
        }
        return id;
    }

    @Override
    public boolean deleteStrongId(String strongId) {

        return strongIdHolder.remove(strongId, Thread.currentThread());

    }


    @Override
    public String distributedId() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
    }
}

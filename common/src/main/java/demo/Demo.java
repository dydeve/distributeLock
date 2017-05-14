package demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dy on 2017/5/10.
 */
public class Demo {

    ExecutorService service = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 10000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("1  " + JSON.toJSONString(event));
            }
        });

        //Stat stat1 = zooKeeper.exists("/stat", true);
        Stat stat2 = zooKeeper.exists("/stat", true);
        zooKeeper.getData(
                "/stat",
                new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        System.out.println("i am here watcher");
                    }
                },
                new AsyncCallback.DataCallback() {
                    @Override
                    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                        System.out.println("i am here callBack");
                        System.out.println(rc);
                        System.out.println(path);
                        System.out.println(JSON.toJSONString(ctx));
                        System.out.println(JSON.toJSONString(stat));
                        for (byte datum : data) {
                            System.out.println(data);
                        }
                        System.out.println(new String(data));

                    }
                }

                ,new Object());
        byte[] a = zooKeeper.getData("/stat", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("sync watcher");
            }
        },
                stat2);
        System.out.println("-----------------");
        System.out.println(new String(a));
        /*List<String> aaa = zooKeeper.getChildren("/stat", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("haha" + JSON.toJSONString(event));
            }
        })
        ;

        System.out.println(JSON.toJSON(aaa));*/

        Thread.sleep(Integer.MAX_VALUE);
    }

    //1  {"state":"SyncConnected","type":"None","wrapper":{"state":3,"type":-1}}

    //1  {"path":"/stat","state":"SyncConnected","type":"NodeDataChanged","wrapper":{"path":"/stat","state":3,"type":3}}
    //2   {"path":"/stat","state":"SyncConnected","type":"NodeDataChanged","wrapper":{"path":"/stat","state":3,"type":3}}

    //1  {"state":"SyncConnected","type":"None","wrapper":{"state":3,"type":-1}}

    //2   {"path":"/stat","state":"SyncConnected","type":"NodeDataChanged","wrapper":{"path":"/stat","state":3,"type":3}}
    //1   {"path":"/stat","state":"SyncConnected","type":"NodeDataChanged","wrapper":{"path":"/stat","state":3,"type":3}}
    //3   {"path":"/stat","state":"SyncConnected","type":"NodeDeleted","wrapper":{"path":"/stat","state":3,"type":2}}


    //3   {"path":"/stat","state":"SyncConnected","type":"NodeCreated","wrapper":{"path":"/stat","state":3,"type":1}}

    //haha{"path":"/stat","state":"SyncConnected","type":"NodeChildrenChanged","wrapper":{"path":"/stat","state":3,"type":4}}



    //1  {"state":"SyncConnected","type":"None","wrapper":{"state":3,"type":-1}}
    //i am here callBack
    //0
    ///stat
    //{}
    //"c3RhdA=="
    //{"aversion":0,"ctime":1494509043041,"cversion":0,"czxid":159,"dataLength":4,"ephemeralOwner":0,"mtime":1494509043041,"mzxid":159,"numChildren":0,"pzxid":159,"version":0}
}

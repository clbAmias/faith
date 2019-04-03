package com.qd.kafka;

import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;

import java.util.Properties;

public class CreateTop {
    private static final String ZK_CONNECT = "localhost:2181,server-2:2181";
    private static final int SESSION_TIMEOUT = 30000;
    private static final int CONNECT_TIMEOUT = 30000;

    public static void createTopic(String topic, int partition, int repilca, Properties properties){
        ZkUtils zkUtils =null;
        try{
            zkUtils = ZkUtils.apply(ZK_CONNECT,SESSION_TIMEOUT,CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
            if (!AdminUtils.topicExists(zkUtils,topic)) {
                AdminUtils.createTopic(zkUtils,topic,partition,repilca,properties,AdminUtils.createTopic$default$6());

            }else {


            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            zkUtils.close();
        }


    }


}

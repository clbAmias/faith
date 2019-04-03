package com.qd.hello;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;

@RestController
public class HelloCtrl {
    private final Logger logger = Logger.getLogger(getClass());


    @RequestMapping(value = "/hello")
    public String index(){
        return "hello world";
    }


//    @Autowired
//    private DiscoveryClient client;
//
//    @RequestMapping(value = "/hello")
//    public String index(){
//        ServiceInstance instance = client.getLocalServiceInstance();
//        logger.info("hello,host:"+instance.getHost()+" service_id:"+instance.getServiceId());
//
//        return "hello world";
//    }

}

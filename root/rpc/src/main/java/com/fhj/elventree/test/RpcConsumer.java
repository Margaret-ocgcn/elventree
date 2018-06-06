package com.fhj.elventree.test;

import com.fhj.elventree.ann.Registration;
import com.fhj.elventree.hello.api.HelloBaseService;
import com.fhj.elventree.hello.api.HelloRequest;
import com.fhj.elventree.hello.api.HelloResponse;
import com.fhj.elventree.model.service.BaseService;
import com.fhj.elventree.model.service.SimpleRequest;
import com.fhj.elventree.model.service.SimpleResponse;

import java.lang.reflect.Proxy;
import java.util.Date;

public class RpcConsumer {

    public static <T> T refer(final Class<T> interfaceClass) throws Exception {
        if (interfaceClass == null) {
            throw new IllegalArgumentException("Interface class == null");
        }
        if (!interfaceClass.isInterface()) {
            throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be api class!");
        }
        if (interfaceClass.isAnnotationPresent(Registration.class)) {
            interfaceClass.getAnnotation(Registration.class);
        }else{
            throw new IllegalAccessException("Error Request Service api has no annotation(Registation)");
        }
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass}, new RpcInvocationHandler());
    }

    public static SimpleResponse doService(BaseService service, SimpleRequest request) throws Exception {
        return (SimpleResponse) service.invoke(request);
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");

        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");

        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "info");
        HelloBaseService service = refer(HelloBaseService.class);

        HelloRequest req = new HelloRequest();
        req.setA(1);
        req.setB("dsfa");
        req.setC(new Date());
        HelloResponse hello = service.invoke(req);
        System.out.println(hello.toString() + "3333333333333");
    }

}
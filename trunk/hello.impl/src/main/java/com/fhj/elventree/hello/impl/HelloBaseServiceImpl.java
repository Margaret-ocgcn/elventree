package com.fhj.elventree.hello.impl;

import com.fhj.elventree.hello.api.HelloBaseService;
import com.fhj.elventree.hello.api.HelloRequest;
import com.fhj.elventree.hello.api.HelloResponse;

public class HelloBaseServiceImpl implements HelloBaseService {

    @Override
    public HelloResponse invoke(HelloRequest request) {
        return new HelloResponse();
    }
}
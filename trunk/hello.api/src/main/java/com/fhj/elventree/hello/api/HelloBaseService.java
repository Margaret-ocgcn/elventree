package com.fhj.elventree.hello.api;


import com.fhj.elventree.ann.Registration;
import com.fhj.elventree.model.service.BaseService;
@Registration(service = "32312", version = "123", method = "23", description = "213")
public interface HelloBaseService extends BaseService<HelloRequest,HelloResponse> {
    HelloResponse invoke(HelloRequest request);
}
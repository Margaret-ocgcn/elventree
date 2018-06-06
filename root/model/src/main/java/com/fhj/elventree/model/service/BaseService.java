package com.fhj.elventree.model.service;

public interface BaseService<T extends BaseRequest,S extends BaseResponse> {
    S invoke(T request);
}

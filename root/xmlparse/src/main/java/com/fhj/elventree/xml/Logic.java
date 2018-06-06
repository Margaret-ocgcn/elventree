package com.fhj.elventree.xml;

import java.io.Serializable;

public class Logic implements Serializable {
    private static final long serialVersionUID = -6171567062293102846L;
    private String id;
    private String flowId;

    private Params request;
    private Params response;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public Params getRequest() {
        return request;
    }

    public void setRequest(Params request) {
        this.request = request;
    }

    public Params getResponse() {
        return response;
    }

    public void setResponse(Params response) {
        this.response = response;
    }
}
package com.fhj.elventree.model.service;

public class SimpleResponse implements BaseResponse {
    private static final long serialVersionUID = 8799979732007043717L;
    private String taskId;
    private long reqTime;

    public SimpleResponse() {
        this.reqTime = System.currentTimeMillis();
    }

    public long getReqTime() {
        return reqTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}

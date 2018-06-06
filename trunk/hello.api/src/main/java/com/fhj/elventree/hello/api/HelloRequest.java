package com.fhj.elventree.hello.api;


import com.fhj.elventree.model.service.SimpleRequest;

import java.util.Date;

public class HelloRequest extends SimpleRequest {
    private int a;
    private String b;
    private Date c;

    public HelloRequest() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Date getC() {
        return c;
    }

    public void setC(Date c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "HelloRequest{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }
}

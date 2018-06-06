package com.fhj.elventree.xml;

import java.io.Serializable;

public class Param implements Serializable {
    private static final long serialVersionUID = -4600966226973847788L;
    private String type;
    private String id;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Param{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

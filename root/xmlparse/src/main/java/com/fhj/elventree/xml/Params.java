package com.fhj.elventree.xml;

import java.io.Serializable;
import java.util.List;

public class Params implements Serializable {
    private static final long serialVersionUID = -6171567062293102846L;
    private String id;
    private List<Param> content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Param> getContent() {
        return content;
    }

    public void setContent(List<Param> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Params{" +
                "id='" + id + '\'' +
                ", content=" + content +
                '}';
    }
}
package com.fhj.elventree.xml;

import java.io.Serializable;
import java.util.List;

public class Flow implements Serializable {
    private static final long serialVersionUID = -6171567062293102846L;
    private String id;
    private List<String> init;
    private List<String> prepare;
    private List<String> logicRef;
    private List<String> end;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getInit() {
        return init;
    }

    public void setInit(List<String> init) {
        this.init = init;
    }

    public List<String> getPrepare() {
        return prepare;
    }

    public void setPrepare(List<String> prepare) {
        this.prepare = prepare;
    }

    public List<String> getLogicRef() {
        return logicRef;
    }

    public void setLogicRef(List<String> logicRef) {
        this.logicRef = logicRef;
    }

    public List<String> getEnd() {
        return end;
    }

    public void setEnd(List<String> end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Flow{" +
                "id='" + id + '\'' +
                ", init=" + init +
                ", prepare=" + prepare +
                ", logicRef=" + logicRef +
                ", end=" + end +
                '}';
    }
}
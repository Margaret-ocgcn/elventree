package com.fhj.elventree.exception;

/**
 * 只有报错说明
 */
public class WardenException extends ElvenException {
    public WardenException(String msg) {
        super(msg);
    }

    @Override
    public String getMsg() {
        return super.getMessage();
    }
}

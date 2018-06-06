package com.fhj.elventree.exception;

import java.util.Arrays;

public abstract class ElvenException extends RuntimeException {
    private static final long serialVersionUID = 7772098349877080712L;
    private Object[] objs;

    public ElvenException(String message, Object[] objs, Throwable throwable) {
        super(message, throwable);
        this.objs = Arrays.copyOfRange(objs,0,objs.length);
    }

    public ElvenException() {
    }

    public ElvenException(String message) {
        super(message);
    }

    public ElvenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElvenException(Throwable cause) {
        super(cause);
    }

    public ElvenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        if (objs != null) {
            for (int i = 0; i < objs.length; i++) {
                if (this.objs[i] != null) {
                    sb.append(this.objs[i]).append(" ");
                }
            }
        }
        if (this.getCause() != null) {
            sb.append("Cause:").append(this.getCause().toString());
        }
        return super.toString();
    }

    /**
     * 如果处理独立异常错误时，调用该方法获取统一报错信息
     *
     * @return
     */
    public abstract String getMsg();

}

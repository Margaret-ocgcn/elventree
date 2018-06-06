package com.fhj.elventree.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 展示错误信息，但记录报错信息
 */
public class TisiphoneException extends ElvenException {
    private String showMsg;
    private static Log log = LogFactory.getLog(TisiphoneException.class);

    public TisiphoneException(String message, String showMsg) {
        super(message);
        this.showMsg = showMsg;
    }

    public TisiphoneException(String message, Throwable cause, String showMsg) {
        super(cause);
        this.showMsg = showMsg;
    }

    @Override
    public String getMsg() {
        log.error(showMsg, this.getCause());
        return showMsg;
    }
}

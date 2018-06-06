package com.fhj.elventree.utils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class BeanFacotry {
    private static Log log=LogFactory.getLog(BeanFacotry.class);
    public Map<String, Object> bean2Map(Object obj) {
        try {
            return (Map<String, Object>) BeanUtils.describe(obj);
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }
}

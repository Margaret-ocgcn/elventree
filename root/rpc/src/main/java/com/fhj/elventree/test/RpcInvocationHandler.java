package com.fhj.elventree.test;

import com.fhj.elventree.utils.HttpUtils;
import com.fhj.elventree.utils.KryoUtils;
import com.fhj.elventree.utils.StringUtils;
import com.google.gson.Gson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RpcInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        if (args.length > 1) {
            throw new RuntimeException("Request error:method params out of range [" + args.length + "]!");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        if (args != null || args.length == 1) {
            byte[] bs = KryoUtils.serializeObject(args[0]);
            map.put("params", bs);
        }
        map.put("paramsTypesName", method.getParameterTypes()[0].getName());
        map.put("methodName", method.getName());
        map.put("retType", method.getReturnType().getName());
        String json = HttpUtils.post("http://127.0.0.1:8888/router/sync", StringUtils.bean2Json(map));
        return StringUtils.json2Bean(json, Class.forName(method.getReturnType().getName()));
    }
}

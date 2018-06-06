package com.fhj.elventree.web;

import com.fhj.elventree.hello.api.HelloResponse;
import com.fhj.elventree.hello.impl.HelloBaseServiceImpl;
import com.fhj.elventree.model.service.BaseService;
import com.fhj.elventree.model.service.SimpleRequest;
import com.fhj.elventree.model.service.SimpleResponse;
import com.fhj.elventree.utils.KryoUtils;
import com.fhj.elventree.utils.StringUtils;
import com.google.common.primitives.Bytes;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/router")
public class RouterController {


    @RequestMapping("/sync")
    public SimpleResponse syncTrans(@RequestBody Map<String, Object> map) {
        map.forEach((n, v) -> {
            System.out.println(n + ":" + v);
        });
        try {
            byte[] bytes = Bytes.toArray((ArrayList<Byte>) map.get("params"));
            Object s = KryoUtils.unserialize(bytes, Class.forName((String) map.get("paramsTypesName")));
            BaseService b = (BaseService) new HelloBaseServiceImpl();
            String str = StringUtils.bean2Json(b.invoke((SimpleRequest) s));
            HelloResponse res = (HelloResponse) StringUtils.json2Bean(str, HelloResponse.class);
            res.setTaskId("123123");
            res.setA(1);
            res.setB("3342");
            res.setC(new Date());

            return res;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


}

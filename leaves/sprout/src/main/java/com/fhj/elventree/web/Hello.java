package com.fhj.elventree.web;

import com.fhj.elventree.hello.api.HelloRequest;
import com.fhj.elventree.hello.impl.HelloBaseServiceImpl;
import com.fhj.elventree.model.service.BaseService;
import com.fhj.elventree.model.service.SimpleRequest;
import com.fhj.elventree.model.service.SimpleResponse;
import com.fhj.elventree.registery.Dict;
import com.fhj.elventree.utils.BeanGetterUtil;
import com.fhj.elventree.utils.KryoUtils;
import com.fhj.elventree.utils.StringUtils;
import com.fhj.elventree.xml.Flow;
import com.fhj.elventree.xml.Logic;
import com.fhj.elventree.xml.Param;
import com.fhj.elventree.xml.Params;
import com.google.common.primitives.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class Hello {
    @Autowired
    private Map errorCode;
    @Autowired
    private Dict dict;
    @Autowired
    private Logic logic;

    @RequestMapping("/sync")
    public SimpleResponse syncTrans(@RequestBody Map<String, Object> map) {
        map.forEach((n,v)->{
            System.out.println(n+":"+v);
        });
        try {
            byte[] bytes = Bytes.toArray((ArrayList<Byte>) map.get("params"));
            Object s = KryoUtils.unserialize(bytes, Class.forName((String) map.get("paramsTypesName")));
            BaseService b = (BaseService) new HelloBaseServiceImpl();
            String str=StringUtils.bean2Json(b.invoke((SimpleRequest) s));
            return StringUtils.json2Bean(str,SimpleResponse.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/hello")
    public String readersBooks(@RequestBody Map<String, Object> map) {
//        System.out.println(account+"+++++++++++++++++++++++");
        Flow flow = (Flow) BeanGetterUtil.getBean("ds");
        System.out.println(flow.toString());
        map.forEach((n, v) -> {
            if ("params".equals(n)) {
                byte[] bytes = Bytes.toArray((ArrayList<Byte>) v);
                HelloRequest m = KryoUtils.unserialize(bytes, HelloRequest.class);
                System.out.println(m.toString());
            } else {
                System.out.println(n + ":" + v);
            }
        });
        System.out.println("Test");
        System.out.println(errorCode.get("Params"));
        System.out.println(dict.getValue("test"));
        System.out.println("--------------------");
        logic = null;
        logic = (Logic) BeanGetterUtil.getBean("logic");
        System.out.println(logic.getId());
        System.out.println(logic.getFlowId());
        System.out.println("--------------------");
        Params request = logic.getRequest();
        System.out.println(request.getId());
        List<Param> list = request.getContent();
        list.forEach((s) -> {
                    System.out.println(s.getId() + ":" + s.getType());
                }
        );
        System.out.println("--------------------");
        Params response = logic.getResponse();
        System.out.println(response.getId());
        list = response.getContent();
        list.forEach((s) -> {
                    System.out.println(s.getId() + ":" + s.getType());
                }
        );
        System.out.println("--------------------");
//        System.out.println(logic.getF().getMap().get("a"));
//        System.out.println(((Test)logic.getF()).getGf());
        return "test";
    }

    public Logic getLogic() {
        return logic;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }

    public void setErrorCode(Map errorCode) {
        this.errorCode = errorCode;
    }

    public Map getErrorCode() {
        return errorCode;
    }

    public void setDict(Dict dict) {
        this.dict = dict;
    }

    public Dict getDict() {
        return dict;
    }
}

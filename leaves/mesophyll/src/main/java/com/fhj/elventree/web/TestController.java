package com.fhj.elventree.web;

import com.fhj.elventree.utils.HttpUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/sync")
    public String syncTrans(Map<String, Object> map) {
        HttpUtils.post();
        return null;
    }
}

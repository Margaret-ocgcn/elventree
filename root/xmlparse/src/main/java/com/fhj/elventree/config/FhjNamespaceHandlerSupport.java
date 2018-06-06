package com.fhj.elventree.config;

import com.fhj.elventree.xml.parse.FlowParser;
import com.fhj.elventree.xml.parse.LogicParser;
import com.fhj.elventree.xml.parse.ParamParser;
import com.fhj.elventree.xml.parse.ParamsParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class FhjNamespaceHandlerSupport extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("param", new ParamParser());
        registerBeanDefinitionParser("params", new ParamsParser());
        registerBeanDefinitionParser("logic", new LogicParser());
        registerBeanDefinitionParser("flow", new FlowParser());
    }
}

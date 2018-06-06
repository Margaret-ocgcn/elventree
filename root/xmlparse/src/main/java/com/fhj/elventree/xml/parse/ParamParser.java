package com.fhj.elventree.xml.parse;

import com.fhj.elventree.xml.Param;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class ParamParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Param.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String id = element.getAttribute("id");
        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        } else {
            parserContext.getDelegate().getReaderContext().error("Param [id] cann't be null!", element);
        }
        String type = element.getAttribute("type");
        builder.addPropertyValue("type", type);
    }

}

package com.fhj.elventree.xml.parse;

import com.fhj.elventree.xml.Params;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import java.util.List;

public class ParamsParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Params.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String id = element.getAttribute("id");
        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        } else {
            parserContext.getDelegate().getReaderContext().error("Params [id] cann't be null!", element);
        }

        List<Element> eles = DomUtils.getChildElementsByTagName(element, "param");
        ManagedList list = new ManagedList();
        list.setMergeEnabled(true);
        for (Element subElement : eles) {
            Object db = parserContext.getDelegate().parsePropertySubElement(subElement, builder.getBeanDefinition());
            list.add(db);
        }
        builder.addPropertyValue("content", list);
    }
}

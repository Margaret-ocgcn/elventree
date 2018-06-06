package com.fhj.elventree.xml.parse;

import com.fhj.elventree.xml.Logic;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LogicParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Logic.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String id = element.getAttribute("id");
        String flowId = element.getAttribute("flowId");
        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        } else {
            parserContext.getDelegate().getReaderContext().error("Logic [id] cann't be null!", element);
        }
        builder.addPropertyValue("flowId", flowId);
        parseChild(element, parserContext, builder);
    }

    public void parseChild(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element subElement = (Element) node;
                String tagName = subElement.getLocalName();
                if ("params".equals(tagName)) {
                    Object db = parserContext.getDelegate().parsePropertySubElement(subElement, builder.getBeanDefinition());
                    String subId = subElement.getAttribute("id");
                    if ("request".equals(subId) || "response".equals(subId)) {
                        builder.addPropertyValue(subId, db);
                    } else {
                        parserContext.getDelegate().getReaderContext().error("params [id] cann't out of ['request','response']!", element);
                    }
                }else if("bean".equals(tagName)){
                    Object db = parserContext.getDelegate().parsePropertySubElement(subElement, builder.getBeanDefinition());
                    builder.addPropertyValue("base", db);
                }
            }
        }
    }


}

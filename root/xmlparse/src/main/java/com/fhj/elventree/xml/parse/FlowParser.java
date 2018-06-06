package com.fhj.elventree.xml.parse;

import com.fhj.elventree.xml.Flow;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FlowParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Flow.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String id = element.getAttribute("id");
        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        } else {
            parserContext.getDelegate().getReaderContext().error("Flow [id] cann't be null!", element);
        }
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node instanceof Element) {
                Element subElement = (Element) node;
                parseChild(subElement, parserContext, builder);
            }
        }
    }

    private void parseChild(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String tagName = element.getLocalName();
        NodeList children = element.getChildNodes();
        ManagedList<String> steps = new ManagedList<String>();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node instanceof Element) {
                Element subElement = (Element) node;
                String step = subElement.getTextContent().trim();
                if (step.isEmpty()) {
                    parserContext.getDelegate().getReaderContext().error("step cann't be null!", element);
                }
                steps.add(step);
            }
        }
        builder.addPropertyValue(tagName, steps);
    }

}

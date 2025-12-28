package com.retail.configuration;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class RuleProcessorFactory {

    private final Map<String, RuleProcessor> processors = new HashMap<>();

    public RuleProcessorFactory(List<RuleProcessor> list) {
        list.forEach(processor -> processors.put(processor.getName(), processor));
    }

    public RuleProcessor getProcessor(String type) {
        return processors.get(type);
    }
}

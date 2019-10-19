package com.camel_orders.camel_processing.Processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class LineBreakToCSVProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {

        String message = exchange.getIn().getBody(String.class);
        String csvMessage = message.replaceAll("\\r\\n|\\r|\\n", ",");
        exchange.getIn().setBody(csvMessage);
    }
}

package com.java_server_replication_routes.replication.Processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ResultHandler implements Processor {

    public void process(Exchange exchange) throws Exception{
        String message = exchange.getIn().getBody(String.class);
        System.out.println(message);
    }
}

package com.java_server_replication_routes.replication.Processors;

import com.java_server_replication_routes.replication.Model.PythonPostRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;



@Component
public class Replication implements Processor {

    public void process(Exchange exchange) throws Exception {
        String message = exchange.getIn().getBody(String.class);
        PythonPostRequest rq = new PythonPostRequest();
            rq.setLast_entry(message);
        exchange.getIn().setBody(rq);
//        exchange.getOut().setHeader(Exchange.HTTP_METHOD, HttpMethod.POST);
//        exchange.getOut().setHeader(Exchange.CONTENT_TYPE, "application/json");
//        exchange.getOut().setHeader("Accept", "application/json");





    }
}

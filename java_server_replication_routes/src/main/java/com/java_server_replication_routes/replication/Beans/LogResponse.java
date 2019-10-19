package com.java_server_replication_routes.replication.Beans;

import com.java_server_replication_routes.replication.Model.PythonPostRequest;
import org.apache.camel.*;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LogResponse{

    @Handler
    public void logResponse(@Body String body, Exchange exchange, @Headers Map headers, @OutHeaders Map outHeaders){
        String message = exchange.getIn().getBody(String.class);
        exchange.getIn().setBody(message);
    }
}

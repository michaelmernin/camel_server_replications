package com.java_server_replication_routes.replication.Beans;

import com.java_server_replication_routes.replication.Model.PythonPostRequest;
import org.apache.camel.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.apache.camel.language.constant.ConstantLanguage.constant;

@Service
public class SendPostToPython {

    @Handler
    public void accessHeaders(@Body String body, Exchange exchange, @Headers Map headers, @OutHeaders Map outHeaders){
        String message = exchange.getIn().getBody(String.class);
        PythonPostRequest rq = new PythonPostRequest();
        rq.setLast_entry(message);
        exchange.getIn().setBody(rq);
    }
}

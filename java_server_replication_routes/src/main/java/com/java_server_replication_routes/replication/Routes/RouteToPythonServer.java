package com.java_server_replication_routes.replication.Routes;

import com.java_server_replication_routes.replication.Beans.LogResponse;
import com.java_server_replication_routes.replication.Beans.SendPostToPython;
import com.java_server_replication_routes.replication.Model.PythonPostRequest;
import com.java_server_replication_routes.replication.Processors.Replication;
import com.java_server_replication_routes.replication.Processors.ResultHandler;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteToPythonServer extends RouteBuilder {
    JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(PythonPostRequest.class);
    @Override
    public void configure() throws Exception {
        CamelContext context = new DefaultCamelContext();

        // using bean
        from("file:numbers?noop=true")
                .bean(SendPostToPython.class)
                .marshal(jacksonDataFormat)
                .setHeader(Exchange.HTTP_METHOD, simple("POST"))
                //.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .setHeader(Exchange.CONTENT_TYPE, constant("form-data"))
                .to("http:127.0.0.1:5000/sync");
                //.bean(LogResponse.class)
                //.to("file:logs");


        // using processor class
//        from("file:numbers?noop=true")
//                .process(new Replication())
//                .marshal(jacksonDataFormat)
//                .setHeader(Exchange.HTTP_METHOD, simple("POST"))
//                //.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
//                .setHeader(Exchange.CONTENT_TYPE, constant("form-data"))
//                .to("http:127.0.0.1:5000/sync")
//                .process(new ResultHandler());



//        from("file:numbers?noop=true")
//                .bean(SendPostToPython.class)
//                .to("http:127.0.0.1:5000/sync");
    }

}

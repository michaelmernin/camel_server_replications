package com.camel_orders.camel_processing.Routes;

import com.camel_orders.camel_processing.Processors.LineBreakToCSVProcessor;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingDefinition;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class LocalHostPublisher8088 extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//        CamelContext context = new DefaultCamelContext();
//        from("binding:direct:start")
//                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
//                .to("http://localhost:8088")
//                .process(new LineBreakToCSVProcessor())
//                .to("file:csv_files");
        //from("http://localhost:8088/").process(new LineBreakToCSVProcessor()).to("file:csv_files");
        //from("jetty:http:localhost:8088/?sessionSupport=True").process(new LineBreakToCSVProcessor()).to("file:csv_files");


    }
}

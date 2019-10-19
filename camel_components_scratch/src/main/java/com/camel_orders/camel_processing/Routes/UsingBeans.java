package com.camel_orders.camel_processing.Routes;

import com.camel_orders.camel_processing.Beans.HelloBean;
import com.camel_orders.camel_processing.Beans.ToCSV;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UsingBeans extends RouteBuilder {

    public void configure() throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        //old way
//        from("direct:hello")
//                .process(new Processor() {
//                    @Override
//                    public void process(Exchange exchange) throws Exception {
//                        String name = exchange.getIn().getBody(String.class);
//                        String answer = hello.hello(name);
//                        exchange.getOut().setBody(answer);
//                    }
//                });

        //good way
//        from("direct:hello").bean("helloBean", "hello");

//        from("file:int_producer?noop=true").bean(ToCSV.class).to("file:bean_consumer");
    }
}

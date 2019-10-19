package com.camel_orders.camel_processing.Beans;

import org.apache.camel.*;
import org.apache.camel.language.XPath;
import org.apache.camel.spi.Registry;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ToCSV {


    public String ToCSVMethod(String bodyOfIncomingMessage) {
        return bodyOfIncomingMessage.replaceAll("\\r\\n|\\r|\\n", ",");
    }


    public String intAddition(String bodyOfIncomingMessage) {
        return String.valueOf(Integer.parseInt(bodyOfIncomingMessage) + 25);
    }

    public String multipleParameters(String body, Exchange exchange, Registry registry){

        return body;
    }

    @Handler
    public String headerParameters(@Body String body, Exchange exchange, Registry registry, @Headers Map headers, @OutHeaders Map outHeaders){

        outHeaders = new HashMap<String, String>();

        outHeaders.put("something", "anotherThing");

        return "ok";
    }
}

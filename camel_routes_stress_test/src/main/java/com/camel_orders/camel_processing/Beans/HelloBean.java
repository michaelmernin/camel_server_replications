package com.camel_orders.camel_processing.Beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class HelloBean {

    public String hello(String name){
        return "Hello " + name;
    }
}

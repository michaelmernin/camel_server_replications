package com.camel_orders.camel_processing.Routes;

import com.camel_orders.camel_processing.Beans.HelloBean;
import com.camel_orders.camel_processing.ContentEnrichers.DataFileEnricher;
import com.camel_orders.camel_processing.Processors.LineBreakToCSVProcessor;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;



@Component
public class Routes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        CamelContext context = new DefaultCamelContext();

//        // processes files into csv, by transforming line breaks into ',' delimiter
//        from("file:internet_orders?noop=true").process(new LineBreakToCSVProcessor()).to("file:csv_files");

//        //processes files, then appends the data from the file in enrich_queue
//        //if file name.equals("blank") file will be renamed with the prefix "no_enrichment_found"
//        from("file:internet_orders?noop=true").process(new LineBreakToCSVProcessor())
//                .pollEnrich("file:enrich_queue?noop=true", new DataFileEnricher()).to("file:csv_enriched_files");

        //Unmarshalls XMl into POJO
       // from("file:xml_orders?noop=true").unmarshal().xstream().to("file:pojos");

        //from("file:xml_orders?noop=true").unmarshal().jaxb().to("file:pojos");
        //from("direct:Letter").marshal().jaxb().to("file:xml_orders");

        //Marshall
        //from("file:xml_orders?noop=true").marshal().xstream().to("file:pojos");

        //Using beans
        //from("file:internet_orders?noop=true").bean(HelloBean.class).to("file:bean_consumer");





    }
}

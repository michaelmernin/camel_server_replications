package com.camel_orders.camel_processing.ContentEnrichers;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Component;

@Component
public class DataFileEnricher implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange){

        if(newExchange.getIn().getHeader("CamelFileName", String.class).equals("blank")){
            String new_body = oldExchange.getIn().getBody(String.class) + '\n' + "No enriched data found";
            oldExchange.getIn().setBody(new_body);
            oldExchange.getIn().setHeader("CamelFileName", "no_enrichment_found_" + oldExchange.getIn().getHeader("CamelFileName", String.class));
            return oldExchange;
        }

        String order = oldExchange.getIn().getBody(String.class);
        String added_info = newExchange.getIn().getBody(String.class);

        String enriched_data_body = order + '\n' + added_info + '\n' + newExchange.getIn().getHeaders();
        oldExchange.getIn().setBody(enriched_data_body);

        return oldExchange;
    }
}

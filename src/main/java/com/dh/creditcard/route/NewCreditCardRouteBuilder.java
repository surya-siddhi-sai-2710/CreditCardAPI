package com.dh.creditcard.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.dh.creditcard.model.NewCreditCardRequest;

@Component
public class NewCreditCardRouteBuilder extends RouteBuilder{

	@Override
	public void configure() {
		

		restConfiguration()
		.bindingMode(RestBindingMode.json);
		rest()
		.post("/v1/newcreditcard")
		.type(NewCreditCardRequest.class)
		
		.consumes("application/json")
		.to("direct:new-Credit-Card");
		
		from("direct:new-Credit-Card")
		.to("bean:newCreditCardService?method=prepareNewCreditCardRequest")
		.log("log 1- ${body}")
		
		.to("http://localhost:8082/newcreditcard?bridgeEndpoint=true")
		.log("log 2 - ${body}")
		
		.to("bean:newCreditCardService?method=prepareNewCreditCardResponse")
		.log("log 3- ${body}");
	}
}

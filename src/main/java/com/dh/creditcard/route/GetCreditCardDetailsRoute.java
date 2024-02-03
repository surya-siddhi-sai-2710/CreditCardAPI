package com.dh.creditcard.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.dh.creditcard.model.GetCreditCardRequest;

@Component
public class GetCreditCardDetailsRoute extends RouteBuilder{

	@Override
	public void configure() {
		
		restConfiguration()
		.bindingMode(RestBindingMode.json);
		rest()
		.post("/v1/getdetails")
		.type(GetCreditCardRequest.class)
		
		.consumes("application/json")
		.to("direct:get-details");
		
		from("direct:get-details")
		
		.to("bean:creditCardService?method=prepareCreditCardRequest")
		.log("log 1- ${body}")
		
		.to("http://localhost:8082/getdetails?bridgeEndpoint=true")
		.log("log 2 - ${body}")
		
		.to("bean:creditCardService?method=prepareCreditCardResponse")
		
		.log("${body}");
	}
}

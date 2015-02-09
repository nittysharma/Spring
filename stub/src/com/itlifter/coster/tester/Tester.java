package com.itlifter.coster.tester;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import com.itlifter.coster.model.AuthReqTransaction;
import com.itlifter.coster.model.AuthResponseTransaction;
import com.itlifter.coster.util.XMLDateFactory;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Tester {
public static void main(String[] args) {
	String uri = "http://localhost:8080/stub/rest/membershipservices/authResponseTransaction";
	AuthReqTransaction authReqTransaction = new AuthReqTransaction();
	authReqTransaction.setFHAccountCode("1234567891");
	authReqTransaction.setFHCLastFourDigits(1234);
	authReqTransaction.setMerchantIdentifier("identifier");
	authReqTransaction.setRetrievalReference("ret");
	authReqTransaction.setTransactionAmount(12.12);
	authReqTransaction.setTransactionDescription("sass");
	authReqTransaction.setTransmissionDateTime(XMLDateFactory
			.getXmlDateObj(new Date()));
	try{
	Client client = Client.create();
	WebResource r=client.resource(uri);
	ClientResponse response = r.type(MediaType.APPLICATION_XML).post(ClientResponse.class,authReqTransaction);
	System.out.println(response.getStatus());
	if(response.getStatus() == 200){
		AuthResponseTransaction authResponseTransaction = response.getEntity(AuthResponseTransaction.class);
		System.out.println(authResponseTransaction.getApprovalCode());
	}else{
		System.out.println("error");
	}
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
}
}

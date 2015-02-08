package com.itlifter.coster.action;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.itlifter.coster.model.AuthReqTransaction;
import com.itlifter.coster.model.AuthResponseTransaction;
import com.itlifter.coster.model.SettlementRequestTransaction;
import com.itlifter.coster.model.SettlementResponseTransaction;
import com.itlifter.coster.util.XMLDateFactory;

@Path("/membershipservices")
public class AuthHandler {
	String result = null;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "API is running";
	}

	// This method is called if XML is request
	/**
	 * 
	 * 
	 * u ll not see xml tag on browser
	 * 
	 * @return
	 */

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLTxtHello() {
		return "<?xml version=\"1.0\"?>" + "<result>its xml" + "</result>";
	}

	/*
	 * 
	 * will see xml tag on browser
	 */

	@Path("authReqTransaction")
	@GET
	@Produces(MediaType.TEXT_XML)
	public AuthReqTransaction sayXMLAuthReq() {
		com.itlifter.coster.model.AuthReqTransaction authReqTransaction = new AuthReqTransaction();
		authReqTransaction.setFHAccountCode("asas");
		authReqTransaction.setFHCLastFourDigits(1234);
		authReqTransaction.setMerchantIdentifier("identifier");
		authReqTransaction.setRetrievalReference("ret");
		authReqTransaction.setTransactionAmount(12.12);
		authReqTransaction.setTransactionDescription("sass");
	
		authReqTransaction.setTransmissionDateTime(XMLDateFactory.getXmlDateObj(new Date()));
		
		

		return authReqTransaction;
		// return
		// "<?xml version='1.0' ?> <a:AuthResponseTransaction xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:a=\"http://www.fingerhut.com/schemas/membershipservices/authorizationresponse\" xsi:schemaLocation=\"http://www.fingerhut.com/schemas/membershipservices/authorizationresponse \"> <FHAccountCode>9999999999</FHAccountCode> <FHCLastFourDigits>9999</FHCLastFourDigits> <TransactionAmount>25.99000</TransactionAmount> <TransmissionDateTime>2005-04-08T14:25:30</TransmissionDateTime> <TransactionDescription>Upto 100 chars </TransactionDescription> <SystemTraceAuditNumber>999999</SystemTraceAuditNumber> <RetrievalReference>3434</RetrievalReference> <CardExpiration>1005</CardExpiration> <ApprovalCode>999999</ApprovalCode> <ResponseCode>99</ResponseCode> <InternalResponseCode>99</InternalResponseCode> </a:AuthResponseTransaction>";
	}

	@Path("authResponseTransaction")
	@POST
	@Produces(MediaType.TEXT_XML)
	public AuthResponseTransaction sayXMLAuthResponse(
			AuthReqTransaction authReqTransaction) {
		System.out.println(authReqTransaction.getFHAccountCode());
		com.itlifter.coster.model.AuthResponseTransaction authResponseTransaction = new AuthResponseTransaction();
		authResponseTransaction.setApprovalCode("11");
		authResponseTransaction.setCardExpiration("cardexp.");
		authResponseTransaction.setFHAccountCode(authReqTransaction
				.getFHAccountCode());
		authResponseTransaction.setFHCLastFourDigits(authReqTransaction
				.getFHCLastFourDigits());
		authResponseTransaction.setRetrievalReference(authReqTransaction
				.getRetrievalReference());
		authResponseTransaction.setTransactionAmount(authReqTransaction
				.getTransactionAmount());
		authResponseTransaction.setTransactionDescription(authReqTransaction
				.getTransactionDescription());
		authResponseTransaction.setTransmissionDateTime(authReqTransaction
				.getTransmissionDateTime());
		authResponseTransaction.setResponseCode("12");
		authResponseTransaction.setSystemTraceAuditNumber(12.232);
		authResponseTransaction.setInternalResponseCode("10");
		return authResponseTransaction;
	}

	@Path("settlementrequest")
	@GET
	@Produces(MediaType.TEXT_XML)
	public SettlementRequestTransaction sayXMLSattlement() {
		com.itlifter.coster.model.SettlementRequestTransaction settlementRequestTransaction = new SettlementRequestTransaction();
		settlementRequestTransaction.setApprovalCode("11");
		settlementRequestTransaction.setFHAccountCode("10");
		settlementRequestTransaction.setFHCLastFourDigits(2123);
		settlementRequestTransaction.setMerchantIdentifier("Comviva");
		settlementRequestTransaction.setRetrievalReference("sanyam");
		settlementRequestTransaction.setSystemTraceAuditNumber(42.12);
		settlementRequestTransaction.setTransactionAmount(1280);
		settlementRequestTransaction.setTransactionDescription("my payment");
		settlementRequestTransaction.setTransmissionDateTime(XMLDateFactory.getXmlDateObj(new Date()));
		settlementRequestTransaction.setTranType("credit");

		return settlementRequestTransaction;
	}

	@Path("settlementresponse")
	@POST
	@Produces(MediaType.TEXT_XML)
	public SettlementResponseTransaction sayXMLResponse(
			SettlementRequestTransaction settlementRequestTransaction) {
		System.out.println(settlementRequestTransaction.getFHAccountCode());
		com.itlifter.coster.model.SettlementResponseTransaction settlementResponseTransaction = new SettlementResponseTransaction();
		settlementResponseTransaction
				.setApprovalCode(settlementRequestTransaction.getApprovalCode());
		settlementResponseTransaction
				.setFHAccountCode(settlementRequestTransaction
						.getFHAccountCode());
		settlementResponseTransaction.setInternalResponseCode("12");
		settlementResponseTransaction
				.setMerchantIdentifier(settlementRequestTransaction
						.getMerchantIdentifier());
		settlementResponseTransaction.setResponseCode("21");
		settlementResponseTransaction
				.setRetrievalReference(settlementRequestTransaction
						.getRetrievalReference());
		settlementResponseTransaction
				.setSystemTraceAuditNumber(settlementRequestTransaction
						.getSystemTraceAuditNumber());
		settlementResponseTransaction
				.setTransactionAmount(settlementRequestTransaction
						.getTransactionAmount());
		settlementResponseTransaction
				.setTransactionDescription(settlementRequestTransaction
						.getTransactionDescription());
		settlementResponseTransaction
				.setTransmissionDateTime(settlementRequestTransaction
						.getTransmissionDateTime());
		settlementResponseTransaction.setTranType(settlementRequestTransaction
				.getTranType());
		return settlementResponseTransaction;
	}

	// This method is called if HTML is request

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "API is running" + "</title>"
				+ "<body><h1>" + "API is running" + "</body></h1>" + "</html> ";
	}

}
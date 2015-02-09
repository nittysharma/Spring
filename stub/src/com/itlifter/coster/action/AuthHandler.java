package com.itlifter.coster.action;

import java.util.Date;

import javax.ws.rs.Consumes;
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
		authReqTransaction.setFHAccountCode("234547");
		authReqTransaction.setFHCLastFourDigits(1234);
		authReqTransaction.setMerchantIdentifier("identifier");
		authReqTransaction.setRetrievalReference("ret");
		authReqTransaction.setTransactionAmount(12.12);
		authReqTransaction.setTransactionDescription("sass");

		authReqTransaction.setTransmissionDateTime(XMLDateFactory
				.getXmlDateObj(new Date()));

		return authReqTransaction;
		// return
		// "<?xml version='1.0' ?> <a:AuthResponseTransaction xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:a=\"http://www.fingerhut.com/schemas/membershipservices/authorizationresponse\" xsi:schemaLocation=\"http://www.fingerhut.com/schemas/membershipservices/authorizationresponse \"> <FHAccountCode>9999999999</FHAccountCode> <FHCLastFourDigits>9999</FHCLastFourDigits> <TransactionAmount>25.99000</TransactionAmount> <TransmissionDateTime>2005-04-08T14:25:30</TransmissionDateTime> <TransactionDescription>Upto 100 chars </TransactionDescription> <SystemTraceAuditNumber>999999</SystemTraceAuditNumber> <RetrievalReference>3434</RetrievalReference> <CardExpiration>1005</CardExpiration> <ApprovalCode>999999</ApprovalCode> <ResponseCode>99</ResponseCode> <InternalResponseCode>99</InternalResponseCode> </a:AuthResponseTransaction>";
	}

	@Path("authResponseTransaction")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public AuthResponseTransaction sayXMLAuthResponse(AuthReqTransaction authReq) {
		System.out.println(authReq.getFHAccountCode());
		com.itlifter.coster.model.AuthResponseTransaction authResponse = new AuthResponseTransaction();
		authResponse.setCardExpiration("cardexp.");
		authResponse.setFHAccountCode(authReq.getFHAccountCode());
		authResponse.setFHCLastFourDigits(authReq.getFHCLastFourDigits());
		authResponse.setRetrievalReference(authReq.getRetrievalReference());
		authResponse.setTransactionAmount(authReq.getTransactionAmount());
		authResponse.setTransactionDescription(authReq
				.getTransactionDescription());
		authResponse.setTransmissionDateTime(authReq.getTransmissionDateTime());
		authResponse.setSystemTraceAuditNumber(12.232);

		// if account code is even then approve request
		if (Integer.parseInt(authReq.getFHAccountCode()) % 2 == 0) {
			authResponse.setApprovalCode("Approved");
			authResponse.setResponseCode("00");
		}
		// account code is odd then reject request
		else {
			// if credit card is even soft decline
			if (authReq.getFHCLastFourDigits() % 2 == 0) {
				authResponse.setResponseCode("13");
				authResponse.setApprovalCode("Invalid Currency Code");
				authResponse.setInternalResponseCode("04");
			}
			// if credit card is even hard decline
			else {
				authResponse.setResponseCode("41");
				authResponse.setApprovalCode("Invalid card- status Lost");
				authResponse.setInternalResponseCode("999");
			}
		}
		return authResponse;
	}

	@Path("settlementrequest")
	@GET
	@Produces(MediaType.TEXT_XML)
	public SettlementRequestTransaction sayXMLSattlement() {
		com.itlifter.coster.model.SettlementRequestTransaction settlementRequestTransaction = new SettlementRequestTransaction();
		settlementRequestTransaction.setApprovalCode("Approved");
		settlementRequestTransaction.setFHAccountCode("234547");
		settlementRequestTransaction.setFHCLastFourDigits(2123);
		settlementRequestTransaction.setMerchantIdentifier("Comviva");
		settlementRequestTransaction.setRetrievalReference("sanyam");
		settlementRequestTransaction.setSystemTraceAuditNumber(42.12);
		settlementRequestTransaction.setTransactionAmount(1280);
		settlementRequestTransaction.setTransactionDescription("my payment");
		settlementRequestTransaction.setTransmissionDateTime(XMLDateFactory
				.getXmlDateObj(new Date()));
		settlementRequestTransaction.setTranType("credit");

		return settlementRequestTransaction;
	}

	@Path("settlementresponse")
	@POST
	@Produces(MediaType.TEXT_XML)
	public SettlementResponseTransaction sayXMLResponse(
			SettlementRequestTransaction settlementReq) {
		System.out.println(settlementReq.getFHAccountCode());
		com.itlifter.coster.model.SettlementResponseTransaction settlementRes = new SettlementResponseTransaction();
		settlementRes.setApprovalCode(settlementReq.getApprovalCode());
		settlementRes.setFHAccountCode(settlementReq.getFHAccountCode());
		settlementRes.setFHCLastFourDigits(settlementReq.getFHCLastFourDigits());
		settlementRes.setMerchantIdentifier(settlementReq
				.getMerchantIdentifier());
		settlementRes.setRetrievalReference(settlementReq
				.getRetrievalReference());
		settlementRes.setSystemTraceAuditNumber(settlementReq
				.getSystemTraceAuditNumber());
		settlementRes
				.setTransactionAmount(settlementReq.getTransactionAmount());
		settlementRes.setTransactionDescription(settlementReq
				.getTransactionDescription());
		settlementRes.setTransmissionDateTime(settlementReq
				.getTransmissionDateTime());
		settlementRes.setTranType(settlementReq.getTranType());
	
		//approved if fh account no. is even
		if (Integer.parseInt(settlementRes.getFHAccountCode()) % 2 == 0) {
			settlementRes.setInternalResponseCode("00");
			settlementRes.setResponseCode("00");
		}
		//reject if odd
		else
		{
			settlementRes.setInternalResponseCode("01");
			settlementRes.setResponseCode("01");
		}
		
		return settlementRes;
	}

	// This method is called if HTML is request

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "API is running" + "</title>"
				+ "<body><h1>" + "API is running" + "</body></h1>" + "</html> ";
	}

}
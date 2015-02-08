package com.itlifter.coster.util;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XMLDateFactory {

	public static XMLGregorianCalendar getXmlDateObj(Date date){
	GregorianCalendar c = new GregorianCalendar();
	c.setTime(date);
	XMLGregorianCalendar xmldate = null;
	try {
		xmldate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
	} catch (DatatypeConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return xmldate;
}


}

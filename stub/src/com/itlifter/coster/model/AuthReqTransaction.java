//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.06 at 12:17:06 PM IST 
//


package com.itlifter.coster.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FHAccountCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\d{10}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FHCLastFourDigits">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;pattern value="\d{4}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TransactionAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TransactionDescription">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TransmissionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="MerchantIdentifier">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="5"/>
 *               &lt;maxLength value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RetrievalReference">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fhAccountCode",
    "fhcLastFourDigits",
    "transactionAmount",
    "transactionDescription",
    "transmissionDateTime",
    "merchantIdentifier",
    "retrievalReference"
})
@XmlRootElement(name = "AuthReqTransaction")
public class AuthReqTransaction {

    @XmlElement(name = "FHAccountCode", required = true)
    protected String fhAccountCode;
    @XmlElement(name = "FHCLastFourDigits")
    protected int fhcLastFourDigits;
    @XmlElement(name = "TransactionAmount")
    protected double transactionAmount;
    @XmlElement(name = "TransactionDescription", required = true)
    protected String transactionDescription;
    @XmlElement(name = "TransmissionDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transmissionDateTime;
    @XmlElement(name = "MerchantIdentifier", required = true)
    protected String merchantIdentifier;
    @XmlElement(name = "RetrievalReference", required = true)
    protected String retrievalReference;

    /**
     * Gets the value of the fhAccountCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFHAccountCode() {
        return fhAccountCode;
    }

    /**
     * Sets the value of the fhAccountCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFHAccountCode(String value) {
        this.fhAccountCode = value;
    }

    /**
     * Gets the value of the fhcLastFourDigits property.
     * 
     */
    public int getFHCLastFourDigits() {
        return fhcLastFourDigits;
    }

    /**
     * Sets the value of the fhcLastFourDigits property.
     * 
     */
    public void setFHCLastFourDigits(int value) {
        this.fhcLastFourDigits = value;
    }

    /**
     * Gets the value of the transactionAmount property.
     * 
     */
    public double getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the transactionAmount property.
     * 
     */
    public void setTransactionAmount(double value) {
        this.transactionAmount = value;
    }

    /**
     * Gets the value of the transactionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionDescription() {
        return transactionDescription;
    }

    /**
     * Sets the value of the transactionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionDescription(String value) {
        this.transactionDescription = value;
    }

    /**
     * Gets the value of the transmissionDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransmissionDateTime() {
        return transmissionDateTime;
    }

    /**
     * Sets the value of the transmissionDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransmissionDateTime(XMLGregorianCalendar value) {
        this.transmissionDateTime = value;
    }

    /**
     * Gets the value of the merchantIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantIdentifier() {
        return merchantIdentifier;
    }

    /**
     * Sets the value of the merchantIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantIdentifier(String value) {
        this.merchantIdentifier = value;
    }

    /**
     * Gets the value of the retrievalReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetrievalReference() {
        return retrievalReference;
    }

    /**
     * Sets the value of the retrievalReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetrievalReference(String value) {
        this.retrievalReference = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.22 at 07:23:07 PM CEST 
//


package jaxb;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CFGCouncil complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFGCouncil">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balconyNum" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="nCounsellorsPerBalcony" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="nInitialGroupReserve" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFGCouncil", propOrder = {
    "balconyNum",
    "nCounsellorsPerBalcony",
    "nInitialGroupReserve"
})
public class CFGCouncil {

    @XmlElement(required = true)
    protected BigInteger balconyNum;
    @XmlElement(required = true)
    protected BigInteger nCounsellorsPerBalcony;
    @XmlElement(required = true)
    protected BigInteger nInitialGroupReserve;

    /**
     * Gets the value of the balconyNum property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBalconyNum() {
        return balconyNum;
    }

    /**
     * Sets the value of the balconyNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBalconyNum(BigInteger value) {
        this.balconyNum = value;
    }

    /**
     * Gets the value of the nCounsellorsPerBalcony property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNCounsellorsPerBalcony() {
        return nCounsellorsPerBalcony;
    }

    /**
     * Sets the value of the nCounsellorsPerBalcony property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNCounsellorsPerBalcony(BigInteger value) {
        this.nCounsellorsPerBalcony = value;
    }

    /**
     * Gets the value of the nInitialGroupReserve property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNInitialGroupReserve() {
        return nInitialGroupReserve;
    }

    /**
     * Sets the value of the nInitialGroupReserve property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNInitialGroupReserve(BigInteger value) {
        this.nInitialGroupReserve = value;
    }

}

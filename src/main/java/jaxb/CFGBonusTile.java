//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.23 at 05:37:25 PM CEST 
//


package jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CFGBonusTile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFGBonusTile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bonuses" type="{urn:co4}CFGBonuses"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFGBonusTile", propOrder = {
    "bonuses"
})
public class CFGBonusTile {

    @XmlElement(required = true)
    protected CFGBonuses bonuses;

    /**
     * Gets the value of the bonuses property.
     * 
     * @return
     *     possible object is
     *     {@link CFGBonuses }
     *     
     */
    public CFGBonuses getBonuses() {
        return bonuses;
    }

    /**
     * Sets the value of the bonuses property.
     * 
     * @param value
     *     allowed object is
     *     {@link CFGBonuses }
     */
    public void setBonuses(CFGBonuses value) {
        this.bonuses = value;
    }

}
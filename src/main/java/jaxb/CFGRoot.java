//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.09 at 08:34:25 PM CEST 
//


package jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CFGRoot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFGRoot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="council" type="{urn:co4}CFGCouncil" minOccurs="0"/>
 *         &lt;element name="politicalDeck" type="{urn:co4}CFGPoliticalDeck"/>
 *         &lt;element name="permissionDecks" type="{urn:co4}CFGPermissionDecks"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFGRoot", propOrder = {
    "council",
    "politicalDeck",
    "permissionDecks"
})
public class CFGRoot {

    protected CFGCouncil council;
    @XmlElement(required = true)
    protected CFGPoliticalDeck politicalDeck;
    @XmlElement(required = true)
    protected CFGPermissionDecks permissionDecks;

    /**
     * Gets the value of the council property.
     * 
     * @return
     *     possible object is
     *     {@link CFGCouncil }
     *     
     */
    public CFGCouncil getCouncil() {
        return council;
    }

    /**
     * Sets the value of the council property.
     * 
     * @param value
     *     allowed object is
     *     {@link CFGCouncil }
     *     
     */
    public void setCouncil(CFGCouncil value) {
        this.council = value;
    }

    /**
     * Gets the value of the politicalDeck property.
     * 
     * @return
     *     possible object is
     *     {@link CFGPoliticalDeck }
     *     
     */
    public CFGPoliticalDeck getPoliticalDeck() {
        return politicalDeck;
    }

    /**
     * Sets the value of the politicalDeck property.
     * 
     * @param value
     *     allowed object is
     *     {@link CFGPoliticalDeck }
     *     
     */
    public void setPoliticalDeck(CFGPoliticalDeck value) {
        this.politicalDeck = value;
    }

    /**
     * Gets the value of the permissionDecks property.
     * 
     * @return
     *     possible object is
     *     {@link CFGPermissionDecks }
     *     
     */
    public CFGPermissionDecks getPermissionDecks() {
        return permissionDecks;
    }

    /**
     * Sets the value of the permissionDecks property.
     * 
     * @param value
     *     allowed object is
     *     {@link CFGPermissionDecks }
     *     
     */
    public void setPermissionDecks(CFGPermissionDecks value) {
        this.permissionDecks = value;
    }

}

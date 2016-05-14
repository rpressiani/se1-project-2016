//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.14 at 03:25:08 PM CEST 
//


package jaxb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CFGPoliticalDeck complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFGPoliticalDeck">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numColors" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="politicalCard" type="{urn:co4}CFGPoliticalCard" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFGPoliticalDeck", propOrder = {
    "numColors",
    "politicalCard"
})
public class CFGPoliticalDeck {

    @XmlElement(required = true)
    protected BigInteger numColors;
    @XmlElement(required = true)
    protected List<CFGPoliticalCard> politicalCard;

    /**
     * Gets the value of the numColors property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumColors() {
        return numColors;
    }

    /**
     * Sets the value of the numColors property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumColors(BigInteger value) {
        this.numColors = value;
    }

    /**
     * Gets the value of the politicalCard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the politicalCard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoliticalCard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CFGPoliticalCard }
     * 
     * 
     */
    public List<CFGPoliticalCard> getPoliticalCard() {
        if (politicalCard == null) {
            politicalCard = new ArrayList<CFGPoliticalCard>();
        }
        return this.politicalCard;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.17 at 01:02:19 PM CEST 
//


package it.cnr.isti.giove.ctt;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObjectClass.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObjectClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Text"/>
 *     &lt;enumeration value="Numerical"/>
 *     &lt;enumeration value="Object"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="Position"/>
 *     &lt;enumeration value="String"/>
 *     &lt;enumeration value="Decimal"/>
 *     &lt;enumeration value="Integer"/>
 *     &lt;enumeration value="Boolean"/>
 *     &lt;enumeration value="Date"/>
 *     &lt;enumeration value="Time"/>
 *     &lt;enumeration value="null"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ObjectClass")
@XmlEnum
public enum ObjectClass {

    @XmlEnumValue("Text")
    TEXT("Text"),
    @XmlEnumValue("Numerical")
    NUMERICAL("Numerical"),
    @XmlEnumValue("Object")
    OBJECT("Object"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("Position")
    POSITION("Position"),
    @XmlEnumValue("String")
    STRING("String"),
    @XmlEnumValue("Decimal")
    DECIMAL("Decimal"),
    @XmlEnumValue("Integer")
    INTEGER("Integer"),
    @XmlEnumValue("Boolean")
    BOOLEAN("Boolean"),
    @XmlEnumValue("Date")
    DATE("Date"),
    @XmlEnumValue("Time")
    TIME("Time"),
    @XmlEnumValue("null")
    NULL("null");
    private final String value;

    ObjectClass(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ObjectClass fromValue(String v) {
        for (ObjectClass c: ObjectClass.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
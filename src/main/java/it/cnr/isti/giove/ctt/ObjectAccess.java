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
 * <p>Java class for ObjectAccess.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObjectAccess">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Access"/>
 *     &lt;enumeration value="Modification"/>
 *     &lt;enumeration value="null"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ObjectAccess")
@XmlEnum
public enum ObjectAccess {

    @XmlEnumValue("Access")
    ACCESS("Access"),
    @XmlEnumValue("Modification")
    MODIFICATION("Modification"),
    @XmlEnumValue("null")
    NULL("null");
    private final String value;

    ObjectAccess(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ObjectAccess fromValue(String v) {
        for (ObjectAccess c: ObjectAccess.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.10.15 a las 11:26:01 PM GMT-03:00 
//


package com.uy.antel.xml.ticket;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para operacionT.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="operacionT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="alta"/>
 *     &lt;enumeration value="cancelacion"/>
 *     &lt;enumeration value="exit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "operacionT")
@XmlEnum
public enum OperacionT {

    @XmlEnumValue("alta")
    ALTA("alta"),
    @XmlEnumValue("cancelacion")
    CANCELACION("cancelacion"),
    @XmlEnumValue("exit")
    EXIT("exit");
    private final String value;

    OperacionT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperacionT fromValue(String v) {
        for (OperacionT c: OperacionT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

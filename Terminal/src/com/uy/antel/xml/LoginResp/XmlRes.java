//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.10.20 a las 08:00:49 PM GMT-03:00 
//


package com.uy.antel.xml.LoginResp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operacion" type="{}operacionT"/>
 *         &lt;element name="xmlRespAltaTicket">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="importeTotal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="nroTicket" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="xmlRespCancelacionTicket">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="nroCancelacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
    "operacion",
    "xmlRespAltaTicket",
    "xmlRespCancelacionTicket"
})
@XmlRootElement(name = "xmlRes")
public class XmlRes {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected OperacionT operacion;
    @XmlElement(required = true, nillable = true)
    protected XmlRes.XmlRespAltaTicket xmlRespAltaTicket;
    @XmlElement(required = true, nillable = true)
    protected XmlRes.XmlRespCancelacionTicket xmlRespCancelacionTicket;

    /**
     * Obtiene el valor de la propiedad operacion.
     * 
     * @return
     *     possible object is
     *     {@link OperacionT }
     *     
     */
    public OperacionT getOperacion() {
        return operacion;
    }

    /**
     * Define el valor de la propiedad operacion.
     * 
     * @param value
     *     allowed object is
     *     {@link OperacionT }
     *     
     */
    public void setOperacion(OperacionT value) {
        this.operacion = value;
    }

    /**
     * Obtiene el valor de la propiedad xmlRespAltaTicket.
     * 
     * @return
     *     possible object is
     *     {@link XmlRes.XmlRespAltaTicket }
     *     
     */
    public XmlRes.XmlRespAltaTicket getXmlRespAltaTicket() {
        return xmlRespAltaTicket;
    }

    /**
     * Define el valor de la propiedad xmlRespAltaTicket.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlRes.XmlRespAltaTicket }
     *     
     */
    public void setXmlRespAltaTicket(XmlRes.XmlRespAltaTicket value) {
        this.xmlRespAltaTicket = value;
    }

    /**
     * Obtiene el valor de la propiedad xmlRespCancelacionTicket.
     * 
     * @return
     *     possible object is
     *     {@link XmlRes.XmlRespCancelacionTicket }
     *     
     */
    public XmlRes.XmlRespCancelacionTicket getXmlRespCancelacionTicket() {
        return xmlRespCancelacionTicket;
    }

    /**
     * Define el valor de la propiedad xmlRespCancelacionTicket.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlRes.XmlRespCancelacionTicket }
     *     
     */
    public void setXmlRespCancelacionTicket(XmlRes.XmlRespCancelacionTicket value) {
        this.xmlRespCancelacionTicket = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="importeTotal" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="nroTicket" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        "error",
        "mensaje",
        "importeTotal",
        "nroTicket"
    })
    public static class XmlRespAltaTicket {

        protected int error;
        @XmlElement(required = true)
        protected String mensaje;
        protected int importeTotal;
        protected int nroTicket;

        /**
         * Obtiene el valor de la propiedad error.
         * 
         */
        public int getError() {
            return error;
        }

        /**
         * Define el valor de la propiedad error.
         * 
         */
        public void setError(int value) {
            this.error = value;
        }

        /**
         * Obtiene el valor de la propiedad mensaje.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMensaje() {
            return mensaje;
        }

        /**
         * Define el valor de la propiedad mensaje.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMensaje(String value) {
            this.mensaje = value;
        }

        /**
         * Obtiene el valor de la propiedad importeTotal.
         * 
         */
        public int getImporteTotal() {
            return importeTotal;
        }

        /**
         * Define el valor de la propiedad importeTotal.
         * 
         */
        public void setImporteTotal(int value) {
            this.importeTotal = value;
        }

        /**
         * Obtiene el valor de la propiedad nroTicket.
         * 
         */
        public int getNroTicket() {
            return nroTicket;
        }

        /**
         * Define el valor de la propiedad nroTicket.
         * 
         */
        public void setNroTicket(int value) {
            this.nroTicket = value;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="nroCancelacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        "error",
        "mensaje",
        "nroCancelacion"
    })
    public static class XmlRespCancelacionTicket {

        protected int error;
        @XmlElement(required = true)
        protected String mensaje;
        protected int nroCancelacion;

        /**
         * Obtiene el valor de la propiedad error.
         * 
         */
        public int getError() {
            return error;
        }

        /**
         * Define el valor de la propiedad error.
         * 
         */
        public void setError(int value) {
            this.error = value;
        }

        /**
         * Obtiene el valor de la propiedad mensaje.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMensaje() {
            return mensaje;
        }

        /**
         * Define el valor de la propiedad mensaje.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMensaje(String value) {
            this.mensaje = value;
        }

        /**
         * Obtiene el valor de la propiedad nroCancelacion.
         * 
         */
        public int getNroCancelacion() {
            return nroCancelacion;
        }

        /**
         * Define el valor de la propiedad nroCancelacion.
         * 
         */
        public void setNroCancelacion(int value) {
            this.nroCancelacion = value;
        }

    }

}

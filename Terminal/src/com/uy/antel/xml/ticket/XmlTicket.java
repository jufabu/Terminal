//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.10.13 a las 04:07:03 PM UYST 
//


package com.uy.antel.xml.ticket;

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
 *         &lt;element name="xmlAltaTicket">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="matricula" type="{}matriculaT"/>
 *                   &lt;element name="fechaHoraInicioEst" type="{}fechaEstT"/>
 *                   &lt;element name="cantidadMinutos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="nroTerminal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="xmlBajaTicket">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nroTicket" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="nroTerminal" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "xmlAltaTicket",
    "xmlBajaTicket"
})
@XmlRootElement(name = "xmlTicket")
public class XmlTicket {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected OperacionT operacion;
    @XmlElement(required = true, nillable = true)
    protected XmlTicket.XmlAltaTicket xmlAltaTicket;
    @XmlElement(required = true, nillable = true)
    protected XmlTicket.XmlBajaTicket xmlBajaTicket;

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
     * Obtiene el valor de la propiedad xmlAltaTicket.
     * 
     * @return
     *     possible object is
     *     {@link XmlTicket.XmlAltaTicket }
     *     
     */
    public XmlTicket.XmlAltaTicket getXmlAltaTicket() {
        return xmlAltaTicket;
    }

    /**
     * Define el valor de la propiedad xmlAltaTicket.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlTicket.XmlAltaTicket }
     *     
     */
    public void setXmlAltaTicket(XmlTicket.XmlAltaTicket value) {
        this.xmlAltaTicket = value;
    }

    /**
     * Obtiene el valor de la propiedad xmlBajaTicket.
     * 
     * @return
     *     possible object is
     *     {@link XmlTicket.XmlBajaTicket }
     *     
     */
    public XmlTicket.XmlBajaTicket getXmlBajaTicket() {
        return xmlBajaTicket;
    }

    /**
     * Define el valor de la propiedad xmlBajaTicket.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlTicket.XmlBajaTicket }
     *     
     */
    public void setXmlBajaTicket(XmlTicket.XmlBajaTicket value) {
        this.xmlBajaTicket = value;
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
     *         &lt;element name="matricula" type="{}matriculaT"/>
     *         &lt;element name="fechaHoraInicioEst" type="{}fechaEstT"/>
     *         &lt;element name="cantidadMinutos" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="nroTerminal" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        "matricula",
        "fechaHoraInicioEst",
        "cantidadMinutos",
        "nroTerminal"
    })
    public static class XmlAltaTicket {

        @XmlElement(required = true)
        protected String matricula;
        @XmlElement(required = true)
        protected String fechaHoraInicioEst;
        protected int cantidadMinutos;
        protected int nroTerminal;

        /**
         * Obtiene el valor de la propiedad matricula.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMatricula() {
            return matricula;
        }

        /**
         * Define el valor de la propiedad matricula.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMatricula(String value) {
            this.matricula = value;
        }

        /**
         * Obtiene el valor de la propiedad fechaHoraInicioEst.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaHoraInicioEst() {
            return fechaHoraInicioEst;
        }

        /**
         * Define el valor de la propiedad fechaHoraInicioEst.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaHoraInicioEst(String value) {
            this.fechaHoraInicioEst = value;
        }

        /**
         * Obtiene el valor de la propiedad cantidadMinutos.
         * 
         */
        public int getCantidadMinutos() {
            return cantidadMinutos;
        }

        /**
         * Define el valor de la propiedad cantidadMinutos.
         * 
         */
        public void setCantidadMinutos(int value) {
            this.cantidadMinutos = value;
        }

        /**
         * Obtiene el valor de la propiedad nroTerminal.
         * 
         */
        public int getNroTerminal() {
            return nroTerminal;
        }

        /**
         * Define el valor de la propiedad nroTerminal.
         * 
         */
        public void setNroTerminal(int value) {
            this.nroTerminal = value;
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
     *         &lt;element name="nroTicket" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="nroTerminal" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        "nroTicket",
        "nroTerminal"
    })
    public static class XmlBajaTicket {

        protected int nroTicket;
        protected int nroTerminal;

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

        /**
         * Obtiene el valor de la propiedad nroTerminal.
         * 
         */
        public int getNroTerminal() {
            return nroTerminal;
        }

        /**
         * Define el valor de la propiedad nroTerminal.
         * 
         */
        public void setNroTerminal(int value) {
            this.nroTerminal = value;
        }

    }

}

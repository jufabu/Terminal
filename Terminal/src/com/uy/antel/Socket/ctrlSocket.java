package com.uy.antel.Socket;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.*;

import java.util.Calendar;

import org.xml.sax.SAXException;

import com.uy.antel.xml.AltaTicket.*;
import com.uy.antel.xml.DataTicket.XmlDataTicket;
import com.uy.antel.xml.Login.XmlLogin;
import com.uy.antel.xml.Login.ObjectFactory;

public class ctrlSocket {
	Socket socket;
	OutputStream out;
	InputStream in;

	private static ctrlSocket instance = null;

	public static ctrlSocket getInstance() {
		if (instance == null) {
			instance = new ctrlSocket();
		}
		return instance;
	}

	public ctrlSocket() {

	}
	
	/**
	 * @param usuario
	 * @param pass
	 */
	public void Login(String usuario, String pass, Integer idTerminal){
		try{
			socket = new Socket("localHost", 8082);
			out = socket.getOutputStream();
			in = socket.getInputStream();
		}catch (UnknownHostException e){
			System.out.println("Unknown host: localhost");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("No I/O");
			System.exit(1);
		}
		
		try{
			com.uy.antel.xml.Login.ObjectFactory factoryLogin = new com.uy.antel.xml.Login.ObjectFactory();

			XmlLogin altaLogin = factoryLogin.createXmlLogin();
			altaLogin.setUsuario(usuario);
			altaLogin.setPassword(pass);
			altaLogin.setNroTerminal(BigInteger.valueOf(idTerminal));
			
			JAXBContext context = JAXBContext.newInstance("com.uy.antel.xml.Login");

			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);

			marshaller.marshal(altaLogin, out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void XmlEnvioAltaTicket(String matricula, String fechaIn, Integer duracion) {
		// Create socket connection

		try {
			socket = new Socket("localhost", 8082);
			out = socket.getOutputStream();
			in = socket.getInputStream();
		} catch (UnknownHostException e) {
			System.out.println("Unknown host: localhost");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("No I/O");
			System.exit(1);
		}

		try {
			com.uy.antel.xml.AltaTicket.ObjectFactory factory = new com.uy.antel.xml.AltaTicket.ObjectFactory();

			XmlAltaTicket altaTicket = factory.createXmlAltaTicket();
			altaTicket.setCantidadMinutos(BigInteger.valueOf(duracion));

			altaTicket.setFechaHoraInicioEst(fechaIn);

			altaTicket.setMatricula(matricula);

			JAXBContext context = JAXBContext.newInstance("com.uy.antel.xml.AltaTicket");

			// JAXBElement<AltaTicket> elemento =
			// factory.createAltaTicket(altaTicket);

			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);

			marshaller.marshal(altaTicket, out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public XmlDataTicket recibeDataTicket(){
		InputStream in = null;
		OutputStream out = null;
		XmlDataTicket ticket = null;
		
		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
		} catch (IOException e) {
			System.out.println("in or out failed");
			System.exit(-1);
		}

		try{		
			while (true) {
			
	//				SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	//				Schema schema;
	//
	//				schema = sf.newSchema(new File("src/com/uy/antel/xml/altaTicket.xsd"));
					JAXBContext jaxbContext;
					jaxbContext = JAXBContext.newInstance(XmlDataTicket.class);
					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	//				jaxbUnmarshaller.setSchema(schema);
					//Hago la conversion de XML -> objeto AltaTicket.
					ticket = (XmlDataTicket) jaxbUnmarshaller.unmarshal(in);
					
					//			} catch (SAXException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
			
			}
		}catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticket;
	}

}
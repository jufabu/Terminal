package com.uy.Socket;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Calendar;

import org.xml.sax.SAXException;

import com.uy.xml.AltaTicket.*;

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

	public void listenSocket(String matricula, GregorianCalendar fechaIn, Integer duracion) {
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
			ObjectFactory factory = new ObjectFactory();

			XmlAltaTicket altaTicket = factory.createXmlAltaTicket();
			altaTicket.setCantidadMinutos(BigInteger.valueOf(duracion));

			GregorianCalendar c = new GregorianCalendar();
			// c.setTime(new Date());
			c = fechaIn;
			XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

			altaTicket.setFechaHoraInicioEst(xgc);

			altaTicket.setMatricula(matricula);

			JAXBContext context = JAXBContext.newInstance("com.uy.xml.AltaTicket");

			// JAXBElement<AltaTicket> elemento =
			// factory.createAltaTicket(altaTicket);

			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);

			marshaller.marshal(altaTicket, out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
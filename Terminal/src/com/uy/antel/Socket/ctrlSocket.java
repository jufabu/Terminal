package com.uy.antel.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.uy.antel.util.util;
import com.uy.antel.xml.Login.XmlLogin;
import com.uy.antel.xml.LoginResp.XmlLoginResp;
import com.uy.antel.xml.respTicket.XmlRes;
import com.uy.antel.xml.ticket.OperacionT;
import com.uy.antel.xml.ticket.XmlTicket;
import com.uy.antel.xml.ticket.XmlTicket.XmlAltaTicket;
import com.uy.antel.xml.ticket.XmlTicket.XmlCancelacionTicket;

public class ctrlSocket {
	Socket socket;
	DataInputStream is = null;
	DataOutputStream os = null;
	// OutputStream out;
	// InputStream in;

	private static ctrlSocket instance = null;

	public static ctrlSocket getInstance() {
		if (instance == null) {
			instance = new ctrlSocket();
		}
		return instance;
	}

	public ctrlSocket() {
		try {
			socket = new Socket("localHost", 8082);
			is = new DataInputStream(socket.getInputStream());
			os = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			System.out.println("Unknown host: localhost");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("No I/O");
			System.exit(1);
		}
	}

	/**
	 * @param usuario
	 * @param pass
	 */
	public void Login(String usuario, String pass, int idTerminal) {

		try {
			com.uy.antel.xml.Login.ObjectFactory factoryLogin = new com.uy.antel.xml.Login.ObjectFactory();

			XmlLogin altaLogin = factoryLogin.createXmlLogin();
			altaLogin.setUsuario(usuario);
			altaLogin.setPassword(pass);
			altaLogin.setNroTerminal(idTerminal);

			JAXBContext context = JAXBContext.newInstance("com.uy.antel.xml.Login");

			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);

			StringWriter writerLog = new StringWriter();
			marshaller.marshal(altaLogin, writerLog);
			os.writeUTF(writerLog.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public XmlLoginResp respuestaLogin() {
		// InputStream in = null;
		// OutputStream out = null;
		XmlLoginResp resLogin = null;
		DataInputStream is = null;
		try {
			is = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("in or out failed");
			System.exit(-1);
		}

		try {
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance(XmlLoginResp.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			// Hago la conversion de XML -> objeto XMLRes.
			resLogin = (XmlLoginResp) jaxbUnmarshaller.unmarshal(new StringReader(is.readUTF()));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return resTicket;
		return resLogin;
	}

	public void XmlEnvioAltaTicket(String matricula, String fechaIn, Integer duracion) {
		// Create socket connection

		try {
			com.uy.antel.xml.ticket.ObjectFactory factory = new com.uy.antel.xml.ticket.ObjectFactory();

			XmlAltaTicket altaTicket = factory.createXmlTicketXmlAltaTicket();
			altaTicket.setCantidadMinutos(duracion);

			altaTicket.setFechaHoraInicioEst(fechaIn);

			altaTicket.setMatricula(matricula);

			XmlTicket tick = factory.createXmlTicket();
			tick.setXmlAltaTicket(altaTicket);
			tick.setOperacion(OperacionT.ALTA);

			JAXBContext context = JAXBContext.newInstance("com.uy.antel.xml.ticket");

			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);

			StringWriter writer = new StringWriter();
			marshaller.marshal(tick, writer);
			os.writeUTF(writer.toString());

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			System.out.println("Unknown host: localhost");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("No I/O");
			System.exit(1);
		}

	}

	public XmlRes recibeRespuestaAltaCancTicket() {
		XmlRes resTicket = null;
		DataInputStream is = null;
		try {
			is = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("in or out failed");
			System.exit(-1);
		}

		try {
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance(XmlRes.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			// Hago la conversion de XML -> objeto XMLRes.
			resTicket = (XmlRes) jaxbUnmarshaller.unmarshal(new StringReader(is.readUTF()));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resTicket;
	}

	public void XmlEnvioCancelacionTicket(int nroTicket) {
		// TODO Auto-generated method stub
		// Create socket connection

		try {
			com.uy.antel.xml.ticket.ObjectFactory factory = new com.uy.antel.xml.ticket.ObjectFactory();

			XmlCancelacionTicket cancelacionTicket = factory.createXmlTicketXmlCancelacionTicket();
			cancelacionTicket.setNroTicket(nroTicket);
			XmlTicket tick = factory.createXmlTicket();
			tick.setXmlCancelacionTicket(cancelacionTicket);
			tick.setOperacion(OperacionT.CANCELACION);

			JAXBContext context = JAXBContext.newInstance("com.uy.antel.xml.ticket");

			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);

			StringWriter writer = new StringWriter();
			marshaller.marshal(tick, writer);
			os.writeUTF(writer.toString());

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			System.out.println("Unknown host: localhost");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("No I/O");
			System.exit(1);
		}

	}

}
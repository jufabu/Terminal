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
import com.uy.antel.xml.LoginResp.XmlResLogin;
import com.uy.antel.xml.respTicket.XmlRes;
import com.uy.antel.xml.ticket.OperacionT;
import com.uy.antel.xml.ticket.XmlTicket;
import com.uy.antel.xml.ticket.XmlTicket.XmlAltaTicket;

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

	}

	/**
	 * @param usuario
	 * @param pass
	 */
	public void Login(String usuario, String pass, int idTerminal) {
		try {
			socket = new Socket("localHost", 8082);
			is = new DataInputStream(socket.getInputStream());
			os = new DataOutputStream(socket.getOutputStream());
			// out = socket.getOutputStream();
			// in = socket.getInputStream();
		} catch (UnknownHostException e) {
			System.out.println("Unknown host: localhost");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("No I/O");
			System.exit(1);
		}

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

	public XmlResLogin respuestaLogin() {
		InputStream in = null;
		OutputStream out = null;
		XmlResLogin resLogin = null;
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
				resLogin = (XmlResLogin) jaxbUnmarshaller.unmarshal(new StringReader(is.readUTF()));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return resTicket;
		return resLogin;
	}

	public void XmlEnvioAltaTicket(String matricula, String fechaIn, Integer duracion) {
		// Create socket connection

		try {
			socket = new Socket(util.getHostServidorTerminal(), util.getPuertoServidorTerminal());
			is = new DataInputStream(socket.getInputStream());
			os = new DataOutputStream(socket.getOutputStream());
			// out = socket.getOutputStream();
			// in = socket.getInputStream();

			com.uy.antel.xml.ticket.ObjectFactory factory = new com.uy.antel.xml.ticket.ObjectFactory();

			XmlAltaTicket altaTicket = factory.createXmlTicketXmlAltaTicket();
			altaTicket.setCantidadMinutos(duracion);

			altaTicket.setFechaHoraInicioEst(fechaIn);

			altaTicket.setMatricula(matricula);
			altaTicket.setNroTerminal(util.getIdTerminal());
			
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

	public XmlRes recibeDataTicket() {
		InputStream in = null;
		OutputStream out = null;
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

}
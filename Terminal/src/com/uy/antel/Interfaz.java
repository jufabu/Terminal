package com.uy.antel;

import java.util.Scanner;

import com.uy.antel.Socket.ctrlSocket;
import com.uy.antel.xml.respTicket.XmlRes;
import com.uy.antel.xml.ticket.OperacionT;

public class Interfaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena;
		String matricula;
		Integer duracion;
		String fechaIn;
		XmlRes ticket;
		Integer error;
		String mensaje;
		Integer idTicket;
		String usuarioLogin;
		String passLogin;
		Integer idTerminal;
		String respuestaLogin;

		/*
		 * System.out.println("Usuario: "); Scanner usuario = new
		 * Scanner(System.in); usuarioLogin = usuario.nextLine();
		 * System.out.println("Password: "); Scanner pass = new
		 * Scanner(System.in); passLogin = pass.nextLine(); idTerminal= 1;
		 * ctrlSocket socketLogin = new ctrlSocket();
		 * socketLogin.Login(usuarioLogin, passLogin, idTerminal);
		 * 
		 * respuestaLogin = socketLogin.respuestaLogin();
		 * 
		 * if(respuestaLogin == "0"){
		 * 
		 * }
		 */

		/* PIDO QUE INGRESE LOS DATOS */
		System.out.println("Ingrese los datos en el siguente orden");
		System.out.println("Matricula fechaInicio(yyyy-MM-dd_HH:mm) duracion(min)");
		Scanner entrada = new Scanner(System.in);

		cadena = entrada.nextLine();
		matricula = cadena.substring(0, 7);
		// fechaIn = cadena.substring(19, 24);
		// fechaIn = fechaIn + " ";
		// fechaIn = fechaIn + cadena.substring(8, 18);
		fechaIn = cadena.substring(8, 24);
		System.out.println("Fecha in:" + fechaIn);
		duracion = Integer.parseInt(cadena.substring(25, cadena.length()));
		ctrlSocket socket = new ctrlSocket();
		socket.XmlEnvioAltaTicket(matricula, fechaIn, duracion);

		ticket = socket.recibeDataTicket();
		error = ticket.getXmlRespAltaTicket().getError();

		if (error == 0 && ticket.getOperacion().toString() == OperacionT.ALTA.toString()) {
			mensaje = ticket.getXmlRespAltaTicket().getMensaje();

			System.out.println(mensaje);
			System.out.println("Los datos de su ticket son:");
			System.out.println(fechaIn);
			System.out.println(matricula);
			System.out.println(duracion);
		}
		else{
			
			System.out.println("Error en la terminal");
		}

	}

	/*
	 * SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); fechaIn
	 * = cadena.substring(8, 24); try { fechaInicio = formatter.parse(fechaIn);
	 * System.out.println("La fecha es: " + formatter.format(fechaInicio)); }
	 * catch (ParseException ex) { ex.printStackTrace(); }
	 */
}

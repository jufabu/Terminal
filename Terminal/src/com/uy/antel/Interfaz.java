package com.uy.antel;

import java.util.Scanner;

import com.uy.antel.Socket.ctrlSocket;
import com.uy.antel.xml.LoginResp.XmlLoginResp;
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
		int idTerminal;
		XmlLoginResp resLogin;
		Integer errorLogin = 1;
		ctrlSocket socket = ctrlSocket.getInstance();
		while (!(errorLogin == 0)) {
			System.out.println("Usuario: ");
			Scanner usuario = new Scanner(System.in);
			usuarioLogin = usuario.nextLine();
			System.out.println("Password: ");
			Scanner pass = new Scanner(System.in);
			passLogin = pass.nextLine();
			System.out.println("Ingrese numero de Terminal: ");
			Scanner terminal = new Scanner(System.in);
			idTerminal = Integer.parseInt(terminal.nextLine());
			socket.Login(usuarioLogin, passLogin, idTerminal);
			resLogin = socket.respuestaLogin();
			errorLogin = resLogin.getError();

			if (errorLogin == 0) {
				System.out.println("Se ha logueado correctamente.");
			} else {
				System.out.println("Error al loguearse.");
			}
		}
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("------------------------Menu terminal------------------------");
			System.out.println("1- Alta Ticket");
			System.out.println("2- Cancelacion Ticket");
			Scanner entrada = new Scanner(System.in);
			cadena = entrada.nextLine();
			try {
				if (1 == Integer.parseInt(cadena)) {
					// Alta de ticket
					/* PIDO QUE INGRESE LOS DATOS */
					System.out.println("Ingrese los datos en el siguente orden");
					System.out.println("Matricula fechaInicio(yyyy-MM-dd_HH:mm) duracion(min)");
					// Scanner entrada = new Scanner(System.in);

					cadena = entrada.nextLine();
					matricula = cadena.substring(0, 7);
					fechaIn = cadena.substring(8, 24);
					duracion = Integer.parseInt(cadena.substring(25, cadena.length()));
					socket.XmlEnvioAltaTicket(matricula, fechaIn, duracion);

					ticket = socket.recibeDataTicket();
					error = ticket.getXmlRespAltaTicket().getError();

					if (error == 0 && ticket.getOperacion().toString() == OperacionT.ALTA.toString()) {
						mensaje = ticket.getXmlRespAltaTicket().getMensaje();
						System.out.println(mensaje);
						System.out.println("Importe a pagar: " + ticket.getXmlRespAltaTicket().getImporteTotal());
						System.out.println("NroTicket: " + ticket.getXmlRespAltaTicket().getNroTicket());

					} else {

						System.out.println("Error: "+ticket.getXmlRespAltaTicket().getError());
						System.out.println(ticket.getXmlRespAltaTicket().getMensaje());
					}
				} else if (2 == Integer.parseInt(cadena)) {
					// Cancelacion de ticket
					System.out.println("Falta Implementar");
				} else {
					System.out.println("Opcion Incorrecta");
				}
			} catch (NumberFormatException e) {
				System.out.println("Se debe ingresar un numero correcto");
			}

		}
	}

	/*
	 * SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); fechaIn
	 * = cadena.substring(8, 24); try { fechaInicio = formatter.parse(fechaIn);
	 * System.out.println("La fecha es: " + formatter.format(fechaInicio)); }
	 * catch (ParseException ex) { ex.printStackTrace(); }
	 */
}

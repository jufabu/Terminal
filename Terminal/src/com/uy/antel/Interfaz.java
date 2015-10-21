package com.uy.antel;

import java.util.Scanner;

import org.apache.commons.lang3.tuple.Pair;

import com.uy.antel.Socket.ctrlSocket;
import com.uy.antel.util.util;
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
		XmlRes xmlResTicket = null;
		Integer error = 0;
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
			System.out.println("3- Exit");
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
					String []argumentos = cadena.split(" ");
					if (argumentos.length == 3) {
						//TODO: validar estas entradas
						Pair<Integer, String> salida = util.validarEntradas(argumentos[0], argumentos[1], argumentos[2]);
						if (salida.getKey() == 0){
							matricula = argumentos[0];
							fechaIn = argumentos[1];
							duracion = Integer.parseInt(argumentos[2]);
							socket.XmlEnvioAltaTicket(matricula, fechaIn, duracion);
	
							xmlResTicket = socket.recibeRespuestaAltaCancTicket();
							error = xmlResTicket.getXmlRespAltaTicket().getError();
							if (error == 0 && xmlResTicket.getOperacion().toString() == OperacionT.ALTA.toString()) {
								mensaje = xmlResTicket.getXmlRespAltaTicket().getMensaje();
								System.out.println(mensaje);
								System.out.println("Importe a pagar: " + xmlResTicket.getXmlRespAltaTicket().getImporteTotal());
								System.out.println("NroTicket: " + xmlResTicket.getXmlRespAltaTicket().getNroTicket());
	
							} else {
	
								System.out.println("Error: "+xmlResTicket.getXmlRespAltaTicket().getError());
								System.out.println(xmlResTicket.getXmlRespAltaTicket().getMensaje());
							}
						}else {
							System.out.println(salida.getValue());
						}
					}else {
						System.out.println("Por favor ingrese los datos correctamente.");
					}
					
				} else if (2 == Integer.parseInt(cadena)) {
					// Cancelacion de ticket
					/* PIDO QUE INGRESE LOS DATOS */
					System.out.println("Ingrese el numero de ticket a cancelar");
					// Scanner entrada = new Scanner(System.in);

					cadena = entrada.nextLine();
					//TODO: validar esta entrada
					int nroTicket = Integer.parseInt(cadena);
					socket.XmlEnvioCancelacionTicket(nroTicket);

					xmlResTicket = socket.recibeRespuestaAltaCancTicket();
					error = xmlResTicket.getXmlRespCancelacionTicket().getError();

					if (error == 0 && xmlResTicket.getOperacion().toString() == OperacionT.CANCELACION.toString()) {
						mensaje = xmlResTicket.getXmlRespCancelacionTicket().getMensaje();
						//ESTE ES EL CODIGO DE CANCELACiON
						System.out.println("La cancelacion " + xmlResTicket.getXmlRespCancelacionTicket().getNroCancelacion()+" se ha realizado con exito.");
						System.out.println(mensaje);
					} else {
						System.out.println("Error: "+xmlResTicket.getXmlRespCancelacionTicket().getError());
						System.out.println(xmlResTicket.getXmlRespCancelacionTicket().getMensaje());
					}
					
					
				} else if(3 == Integer.parseInt(cadena)){
					
					System.out.println("Esta seguro que desea salir? S/N");
					cadena = entrada.nextLine();
					if ("S".equals(cadena.toUpperCase())){
						try{
							socket.XmlExit();
							break;
						}catch(Exception e){
							System.out.println("Error al salir del Sistema.");
						}						
					}else if ("N".equals(cadena.toUpperCase())){
						
					}else {
						System.out.println("Opcion Incorrecta.");
					}					
				} else {
					System.out.println("Opcion Incorrecta, seleccione una de las opciones del menu.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Se debe ingresar un numero correcto.");
			}

		}
	}

}

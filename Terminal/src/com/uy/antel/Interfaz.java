package com.uy.antel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import com.uy.xml.AltaTicket.*;
import com.uy.Socket.*;

public class Interfaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena;
		String matricula;
		Integer duracion;
		Date fechaInicio;
		String fechaIn;
		String hora;

		/* PIDO QUE INGRESE LOS DATOS */
		System.out.println("Ingrese los datos en el siguente orden");
		System.out.println("Matricula fechaInicio horaInicio(HH:MM) duracion(min)");
		Scanner entrada = new Scanner(System.in);
		
		cadena = entrada.nextLine();
		matricula = cadena.substring(0, 7);
		fechaIn = cadena.substring(19, 24);
		fechaIn = fechaIn + " ";
		fechaIn = fechaIn + cadena.substring(8, 18);

		DateFormat dateFormat = new SimpleDateFormat("hh:mm dd/MM/yyyy");
		dateFormat.setLenient(false);
		GregorianCalendar cal = new GregorianCalendar();
		try {
			Date d = dateFormat.parse(fechaIn);			
			cal.setTime(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		duracion = Integer.parseInt(cadena.substring(25, cadena.length()));
		// System.out.println("La duracion es : " + duracion);
		ctrlSocket socket = new ctrlSocket();
		socket.listenSocket(matricula,cal,duracion);
		
	}
	
	/*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	fechaIn = cadena.substring(8, 24);
	try {
		fechaInicio = formatter.parse(fechaIn);
		System.out.println("La fecha es: " + formatter.format(fechaInicio));
	} catch (ParseException ex) {
		ex.printStackTrace();
	}*/
}

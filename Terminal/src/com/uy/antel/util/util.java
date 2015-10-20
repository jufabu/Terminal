package com.uy.antel.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class util {
	
	private static String formatoEsperadoFecha = "yyyy-MM-dd_HH:mm";

	public static int getPuertoServidorTerminal() {
//		TODO: arreglar estode  sde una properti
//		Properties prop = new Properties();
//		try {
//			prop.load(new FileInputStream("propiedades.properties"));
//		} catch (IOException e) {
//		}
//		return Integer.parseInt(prop.get("puertoTerminales").toString());
		return 8082;
	}

	public static String getHostServidorTerminal() {
//		TODO: arreglar estode  sde una properti
//		Properties prop = new Properties();
//		try {
//			prop.load(new FileInputStream("propiedades.properties"));
//		} catch (IOException e) {
//		}
//		return Integer.parseInt(prop.get("puertoTerminales").toString());
		return "localhost";
	}
	
	public static int getIdTerminal() {
//		TODO: arreglar estode  sde una properti
//		Properties prop = new Properties();
//		try {
//			prop.load(new FileInputStream("propiedades.properties"));
//		} catch (IOException e) {
//		}
//		return prop.get("idAgencia").toString();
		return 1;
	}

	public static Date stringToDate(String fechaStr) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
		return format.parse(fechaStr);
	}

	public static String dateToString(Date fecha) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_hh:mm");
		return format.format(fecha);
	}
	
	public static boolean esValidaFecha(String fecha) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat(formatoEsperadoFecha);
	    dateFormat.setLenient(false);
	    try {
	      dateFormat.parse(fecha.trim());
	    } catch (ParseException pe) {
	      return false;
	    }
	    return true;
   }
	
	private static boolean validarMatricula(String matricula) {
		boolean ok = (matricula.length() == 7);
		if (ok) {
			Pattern pIni3Letras = Pattern.compile("[a-zA-Z]{3}[0-9]{4}");
			Matcher m = pIni3Letras.matcher(matricula);
			ok = m.find();
		}
		return ok;
	}
	
	public static boolean validarEntradas(String matricula, String fecha, String duracion){
		if (validarMatricula(matricula)){
			if (esValidaFecha(fecha)){
				if (validarTiempo(duracion)){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public static boolean validarTiempo(String duracion){
		Integer cantMinutos;
		if (duracion != null){
			cantMinutos = Integer.parseInt(duracion);
			if ((cantMinutos % 30 == 0) && (cantMinutos > 0)){
				return true;
			}else{
				return false;
			}			
		}else{
			return false;
		}
	}
}

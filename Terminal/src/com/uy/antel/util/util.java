package com.uy.antel.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class util {

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
}

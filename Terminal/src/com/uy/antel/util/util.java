package com.uy.antel.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class util {

	public static int getPuertoTerminal() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("propiedades.properties"));
		} catch (IOException e) {
		}
		return Integer.parseInt(prop.get("puertoTerminales").toString());
	}

	public static String getIdAgencia() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("propiedades.properties"));
		} catch (IOException e) {
		}
		return prop.get("idAgencia").toString();
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

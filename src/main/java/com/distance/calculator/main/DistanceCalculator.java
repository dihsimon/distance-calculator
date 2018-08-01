package com.distance.calculator.main;


/**
 * Classe para calcular distancia entre latitude e longitude
 * Classe modificada do site GeoDataSource.com
 * @author Diego
 * @since 31/07/2018
 */
public class DistanceCalculator {
	
	public static void main(String[] args) {
		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "M") + " Milhas\n");
		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "K") + " KM\n");
		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "N") + " Milhas náuticas\n");
	}
	
	/**
	 * metodo para calcular a distancia
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @param unit
	 * @return
	 */
	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		double dif = lon1 - lon2;
		double dist = calcular(lat1, lon1, lat2, dif);
		dist = Math.acos(dist);
		dist = convertRadInDecimals(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}
		return (truncate(dist));
	}
	
	public static double calcular(double latitude1, double longitude1, double latitude2, double dif) {
		return Math.sin(convertDecimalsInRad(latitude1)) * Math.sin(convertDecimalsInRad(latitude2)) + Math.cos(convertDecimalsInRad(latitude1)) * Math.cos(convertDecimalsInRad(latitude2)) * Math.cos(convertDecimalsInRad(dif));
	}

	/**
	 * Esta função converte graus decimais em radianos
	 * @param deg
	 * @return double
	 */
	private static double convertDecimalsInRad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/**
	 * Esta função converte radianos em graus decimais
	 * @param rad
	 * @return double
	 */
	private static double convertRadInDecimals(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	/**
	 * Formatar valor do calculo para 2 casas depois da virgula
	 * @param value
	 * @return valor com 2 casas decimais
	 */
	public static double truncate(double value) {
	    return Math.round(value * 100) / 100d;
	}
}

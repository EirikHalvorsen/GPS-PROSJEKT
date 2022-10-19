package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.util.Locale;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START
		
		min = da[0];
		
		for (double d : da) {
			if (d < min ) {
				min = d;
			}
		}
			

		return min;
		

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] latitudes = new double[gpspoints.length];
		int i = 0;
		
		for (GPSPoint g: gpspoint) {
			latitudes[i] = g.getLatitude();
			i++;
			
		}
		
		return latitudes;
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double [] longitudes = new double[gpspoints.length];
		int i = 0;
		
		for (GPSPoint g: gpspoints) {
			    longitudes[i] = g.getLongitude();
			    i++;
			
		}
		return longitudes;
		
				
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		
		// Gjør latitude og longitude om til radianer
		
		latitude1 = toRadians(gpspoint1.getLatitude());
		latitude2 = toRadians(gpspoint2.getLatitude());
		
		longitude1 = toRadians(gpspoint1.getLongitude());
		longitude2 = toRadians(gpspoint2.getLongitude());
		
		
		double deltaPhi = latitude2 - latitude1;
		double deltaLambda = longitude2 - longitude1;
		
		
		double a = pow(sin(deltaPhi/2), 2) + cos(latitude1) * cos(latitude2) * pow(sin(deltaLambda/2), 2);
		double c = 2 * atan2(sqrt(a), sqrt(1-a));
		d = R * c;
		
				

		
        return d;
        
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		double distance = distance(gpspoint1, gpspoint2);
		
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		speed = (distance/secs)*3.6;
		
		return speed;
	

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		int hh = secs/3600;
		int rest = secs%3600;
		int mm = rest/60;
		int ss = rest%60;
		
		String hhStr = String.format("%02d", hh);
		String mmStr = String.format("%02d", mm);
		String ssStr = String.format("%02D", ss);
		
		timestr = hhStr + TIMESEP + mmstr + TIMESEP + ssStr;
		
		timestr = String.format("%10s", timestr);
		
		return timestr;
		
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START
		
		str = String.format(Locale.US, "%.2f", d);
		str = String.format("%" + TEXTWIDTH + "s", str);
		
		return str;
		
		// TODO - SLUTT
		
	}
}

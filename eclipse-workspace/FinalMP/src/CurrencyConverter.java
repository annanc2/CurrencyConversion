import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CurrencyConverter {

	public static String[] getCurrencyCodes() {
		String filename = "currency.csv";
		Scanner sc = null;
		List<String> lines = new ArrayList<String>();
		String line;
		try {
			 sc = new Scanner(new File(filename));
			 while (sc.hasNextLine()) {
				line = sc.nextLine();
				if ( line.startsWith("Currency")) {
					continue; // skips header
				}else {
					lines.add(line);
				}
			  
			   }
			}
		catch(Exception e) {
				e.printStackTrace();
			}
	    finally {
				if ( sc != null) {
					sc.close();
				}
			}
			
			String[] CurrenyCodes = lines.toArray(new String[0]);
			return CurrenyCodes;
	}
	
	public static String[] getAvailableDates() {
		String filename = "Currencyratessample.csv";
		Scanner sc = null;
		List<String> lines = new ArrayList<String>();
		String line;
		try {
			 sc = new Scanner(new File(filename));
			 while (sc.hasNextLine()) {
				line = sc.nextLine();
				if(line.startsWith("Date")) {
					continue;
				}
				if (!lines.contains(line.split(",")[0])) {
					lines.add(line.split(",")[0]);
				}
			   }
			}
		catch(Exception e) {
				e.printStackTrace();
			}
	    finally {
				if ( sc != null) {
					sc.close();
				}
			}
			
		 String[] dates = lines.toArray(new String[0]);
			return dates;
	}
	
	public static double getRate(String date, String code) {
		String filename = "Currencyratessample.csv";
		Scanner sc = null;
		String line;
		double rate = 0.0;
		try {
			 sc = new Scanner(new File(filename));
			 while (sc.hasNextLine()) {
				line = sc.nextLine();
				if(line.startsWith("Date")) {
					continue;
				}
				if ((line.split(",")[0].equals(date) && line.split(",")[1].equals(code))) {
					rate = Double.parseDouble(line.split(",")[2]);
					break;
				}
			   }
			}
		catch(Exception e) {
				e.printStackTrace();
			}
	    finally {
				if ( sc != null) {
					sc.close();
				}
			}
			return rate;
	}

}

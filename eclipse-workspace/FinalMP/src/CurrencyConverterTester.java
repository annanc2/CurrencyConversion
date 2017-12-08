
public class CurrencyConverterTester {
	public static void main(String[] args) {
		
	String[] CurrencyCodes = CurrencyConverter.getCurrencyCodes();
	
	for (int i = 0; i < CurrencyCodes.length; i++) {
		System.out.println(CurrencyCodes[i]); // print code and name
		//System.out.println(CurrencyCodes[i].split(",")[0]); //print code
	}
	
	System.out.println("----------------Dates-------------------------");
    String[] dates = CurrencyConverter.getAvailableDates();
	for (int i = 0; i < dates.length; i++) {
		System.out.println(dates[i]); // print date
	}
	
	System.out.println("----------------Rate-------------------------");
	
	System.out.println(CurrencyConverter.getRate("11/30/2017", "AUD"));
	
	}

}

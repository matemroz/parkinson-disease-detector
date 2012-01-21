package pw.inz.pd.db.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatConverter {
	public static String createTimeStamp(){
		Date today;
		String output;
		SimpleDateFormat formatter;

		Locale currentLocale = new Locale("pl", "pl_PL");
		formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss:SSS" , currentLocale);
		today = new Date();
		output = formatter.format(today);
		
		System.out.println(output);
		return output;
	}
}

package Date_Format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Format {
	
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(date.getTime());
		System.out.println(format.format(date));
	}
}

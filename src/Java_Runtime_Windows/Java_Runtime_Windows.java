package Java_Runtime_Windows;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Java_Runtime_Windows {

	public static void main(String[] args) {

		Runtime runtime = Runtime.getRuntime();
		try {
			Date dd = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String date = format.format(dd.getTime());
			String path = "d:/logs/"+ "datacollection.ba_zd_futures_contract_data" +"_"+ date + ".sql";
			String coulme = null;
			if("datacollection.ba_zd_futures_contract_data".equals("datacollection.ba_zd_futures_contract_data")){
				coulme = "LAST_UPD_DATE";
			} else {
				coulme = "TRADING_DAY";
			}
			String runCommand = "cmd /c mysql "
					+ " -h" + "192.168.100.232"
					+ " -u" + "root"
					+ " -p" + "root123456"
					+ " -e\" "
					+ " SELECT "
					+ " * "
					+ " FROM "
					+ "datacollection.ba_zd_futures_contract_data" + " c "
					+ " WHERE "
					+ " TO_DAYS(NOW( ))- TO_DAYS( "+coulme+") > 30"+ "\" "
					+ " > " + path;
			runtime.exec(runCommand);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}

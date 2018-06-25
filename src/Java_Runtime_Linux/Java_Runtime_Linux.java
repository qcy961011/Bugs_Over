package Java_Runtime_Linux;

import java.io.IOException;


/**
 * 在Java程序中运行Linux系统执行的写法
 * @author Administrator
 *
 */
public class Java_Runtime_Linux {

	
	public static void main(String[] args) throws IOException {
	//	String runCommand = "sh / mysql -h192.168.100.232 -uroot -proot123456 –default-character-set=utf8 -e\"use datacenter;select * from ba_ctp_futures_depth_market_data WHERE c.TRADING_DAY = '20180522';\" >/mnt/his/ctp_20180522.xls";
				String runCommand = "mysql "
				+ " -h" + "192.168.100.232"
				+ " -u" + "root"
				+ " -p" + "root123456"
				+ " -e\" "
				+ " SELECT "
				+ " c.ROW_ID, "
				+ " c.TRADING_DAY, "
				+ " c.INSTRUMENT_ID, "
				+ " c.EXCHANGE_ID, "
				+ " c.EXCHANGE_INST_ID, "
				+ " c.LAST_PRICE, "
				+ " c.PRE_SETTLEMENT_PRICE, "
				+ " c.PRE_CLOSE_PRICE, "
				+ " c.OPEN_PRICE, "
				+ " c.HIGHEST_PRICE, "
				+ " c.LOWEST_PRICE, "
				+ " c.VOLUME, "
				+ " c.TURNOVER, "
				+ " c.OPEN_INTEREST, "
				+ " c.CLOSE_PRICE, "
				+ " c.SETTLEMENT_PRICE "
				+ " FROM "
				+ " datacenter.ba_ctp_futures_depth_market_data" + " c "
				+ " WHERE "
				+ " c.TRADING_DAY = '"+ "20180522" +"'\" "
				+ " > " + "/mnt/his/ctp_"+ "20180522" + ".xls";
		Runtime runtime = Runtime.getRuntime();
		runtime.exec(runCommand);
		System.out.println(runCommand);
	}
}

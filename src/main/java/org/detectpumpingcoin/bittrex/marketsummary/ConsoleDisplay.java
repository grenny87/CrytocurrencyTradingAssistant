package org.detectpumpingcoin.bittrex.marketsummary;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.detectpumpingcoin.entity.MarketSummary;
import org.detectpumpingcoin.entity.MarketSummaryWrapper;

public class ConsoleDisplay implements Display {
	
	private DecimalFormat format = new DecimalFormat("0");
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public ConsoleDisplay() {
		format.setMaximumFractionDigits(8);
		format.setMinimumFractionDigits(8);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7"));
	}

	@Override
	public void show(MarketSummaryWrapper marketSummaryWrapper) {
		MarketSummary lastestMarketSummary = marketSummaryWrapper.getLatestMarketSummary();
		MarketSummary previousMarketSummary = marketSummaryWrapper.getPreviousMarketSuammry();
		
		try {
			System.out.println("Pumping coin: " + lastestMarketSummary.getMarketName() +
					" - Previous price: " + format.format(previousMarketSummary.getLast())+
					" - Latest Price: " + format.format(lastestMarketSummary.getLast()) +
			" - Timestamp: " + sdf2.format(sdf.parse(lastestMarketSummary.getTimeStamp())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

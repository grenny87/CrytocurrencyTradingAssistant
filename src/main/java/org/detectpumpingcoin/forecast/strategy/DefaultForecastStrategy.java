package org.detectpumpingcoin.forecast.strategy;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.detectpumpingcoin.entity.MarketSummary;
import org.detectpumpingcoin.forecast.PumpingCoinForecastParam;

public class DefaultForecastStrategy implements ForecastStrategy {
	
	private List<PumpingCoinForecastParam> params;
	
	private DecimalFormat format = new DecimalFormat("0");
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public DefaultForecastStrategy(List<PumpingCoinForecastParam> params){
		this.params = params;
	}
	@Override
	public List<String> doOperation() {
		format.setMaximumFractionDigits(8);
		format.setMinimumFractionDigits(8);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		if (params != null && params.size()>1) {
			PumpingCoinForecastParam previousInfo = getPreviousInfo(params);
			PumpingCoinForecastParam latestInfo = getLatestInfo(params);
			return getPumpingCoin(previousInfo, latestInfo);
		}
		return new ArrayList<String>();
	}

	private PumpingCoinForecastParam getPreviousInfo(List<PumpingCoinForecastParam> params2) {
		return params2.get(params2.size() - 2);
	}
	private PumpingCoinForecastParam getLatestInfo(List<PumpingCoinForecastParam> params2) {
		// TODO Auto-generated method stub
		return params2.get(params2.size() - 1);
	}
	
	private List<String> getPumpingCoin(PumpingCoinForecastParam previousInfo, PumpingCoinForecastParam latestInfo ) {
		List<MarketSummary> previousMarketSummaries = previousInfo.getMarketSummaries();
		List<MarketSummary> lastestMarketSummaries = latestInfo.getMarketSummaries();
		ArrayList<String> pumpingCoins= new ArrayList<>();
		List<MarketSummary> previousMarketSummariesBTC = previousMarketSummaries
				.stream()
				.filter(item -> item.getMarketName().contains("BTC-"))
				.collect(Collectors.toList());
		
		for (MarketSummary previousMarketSummary: previousMarketSummariesBTC) {
			
			for (MarketSummary lastestMarketSummary : lastestMarketSummaries) {
				if (previousMarketSummary.getMarketName().equals(lastestMarketSummary.getMarketName()) 
						&& lastestMarketSummary.getLast() > (previousMarketSummary.getLast() * (1 + (getIncreasementRate()/100)))) {
					try {
						System.out.println("Pumping coin: " + lastestMarketSummary.getMarketName() +
										" - Previous price: " + format.format(previousMarketSummary.getLast())+
										" - Latest Price: " + format.format(lastestMarketSummary.getLast()) +
								" - Timestamp: " + sdf2.format(sdf.parse(lastestMarketSummary.getTimeStamp())));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pumpingCoins.add(lastestMarketSummary.getMarketName());
					continue;
				}
			}
		}
		return pumpingCoins;
	}
	
	
	
	@Override
	public int getFrametimeForecasting() {
		return 5*1000;
	}

	@Override
	public double getIncreasementRate() {
		// TODO Auto-generated method stub
		return 1;
	}


}

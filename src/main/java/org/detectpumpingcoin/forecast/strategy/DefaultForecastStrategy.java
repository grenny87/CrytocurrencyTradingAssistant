package org.detectpumpingcoin.forecast.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.detectpumpingcoin.bittrex.marketsummary.ConsoleDisplay;
import org.detectpumpingcoin.bittrex.marketsummary.DisplayDecorator;
import org.detectpumpingcoin.entity.MarketSummary;
import org.detectpumpingcoin.entity.MarketSummaryWrapper;
import org.detectpumpingcoin.forecast.PumpingCoinForecastParam;

public class DefaultForecastStrategy implements ForecastStrategy {

	private DisplayDecorator displayDecorator;

	private List<PumpingCoinForecastParam> params;

	public DefaultForecastStrategy(List<PumpingCoinForecastParam> params) {
		this.params = params;
		displayDecorator = new DisplayDecorator(new ConsoleDisplay());
	}

	@Override
	public List<String> doOperation() {

		if (params != null && params.size() > 1) {
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

	private List<String> getPumpingCoin(PumpingCoinForecastParam previousInfo, PumpingCoinForecastParam latestInfo) {
		List<MarketSummary> previousMarketSummaries = previousInfo.getMarketSummaries();
		List<MarketSummary> lastestMarketSummaries = latestInfo.getMarketSummaries();
		ArrayList<String> pumpingCoins = new ArrayList<>();
		List<MarketSummary> previousMarketSummariesBTC = previousMarketSummaries.stream()
				.filter(item -> item.getMarketName().contains("BTC-")).collect(Collectors.toList());

		for (MarketSummary previousMarketSummary : previousMarketSummariesBTC) {

			for (MarketSummary lastestMarketSummary : lastestMarketSummaries) {
				if (previousMarketSummary.getMarketName().equals(lastestMarketSummary.getMarketName())
						&& lastestMarketSummary
								.getLast() > (previousMarketSummary.getLast() * (1 + (getIncreasementRate() / 100)))) {
					displayDecorator.doDisplay(new MarketSummaryWrapper(lastestMarketSummary, previousMarketSummary));
					pumpingCoins.add(lastestMarketSummary.getMarketName());
					continue;
				}
			}
		}
		return pumpingCoins;
	}

	@Override
	public int getFrametimeForecasting() {
		return 5 * 1000;
	}

	@Override
	public double getIncreasementRate() {
		// TODO Auto-generated method stub
		return 1;
	}

}

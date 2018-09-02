package org.detectpumpingcoin;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.detectpumpingcoin.entity.MarketSummary;
import org.detectpumpingcoin.forecast.PumpingCoinForecastParam;
import org.detectpumpingcoin.forecast.context.MarketContext;
import org.detectpumpingcoin.forecast.strategy.DefaultForecastStrategy;
import org.detectpumpingcoin.forecast.strategy.ForecastStrategy;
import org.detectpumpingcoin.request.BittrexRequestClient;

public class DetectPumpingCoin {
	final static Logger logger = LogManager.getLogger(DetectPumpingCoin.class);

	public static void main(String[] args) {
		List<PumpingCoinForecastParam> params = new ArrayList<PumpingCoinForecastParam>();
		logger.trace(">> DetectPumpingCoin start");
		int i = 1;
		while (true) {
			try {
				List<MarketSummary> marketSummaries = BittrexRequestClient.getInstance().getMarketSummaries();
				PumpingCoinForecastParam param = new PumpingCoinForecastParam();
				param.setMarketSummaries(marketSummaries);
				params.add(param);
				ForecastStrategy strategy = new DefaultForecastStrategy(params);
				MarketContext context = new MarketContext(strategy);
				System.out.println(i + "forecast "+ context.doForecasting());
				Thread.sleep(strategy.getFrametimeForecasting());
			} catch (URISyntaxException | InterruptedException e) {
				logger.error("Cannot getMarketSummaries", e);
			}
			i++;
		}
	}
}

;
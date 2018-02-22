package org.detectpumpingcoin;

import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.detectpumpingcoin.entity.MarketSummary;
import org.detectpumpingcoin.request.BittrexRequestClient;

public class DetectPumpingCoin {
	final static Logger logger = Logger.getAnonymousLogger();

	public static void main(String[] args) {
		int i = 1;
		while (true) {
			try {
				List<MarketSummary> marketSummaries = BittrexRequestClient.getInstance().getMarketSummaries();
				Thread.sleep(5 * 1000);
			} catch (URISyntaxException e) {
				logger.log(Level.SEVERE, "Cannot getMarketSummaries", e);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}
}

;
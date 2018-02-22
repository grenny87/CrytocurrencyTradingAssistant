package org.detectpumpingcoin.request.generator.test;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.detectpumpingcoin.enums.BittrexOrderType;
import org.detectpumpingcoin.request.generator.BittrexRequestGenerator;
import org.junit.Test;

public class BittrexRequestGeneratorTest {
	
	@Test
    public void canGetOrderBook() throws URISyntaxException {
		String url = BittrexRequestGenerator.getInstance().getOrderBook("BTC-SC", BittrexOrderType.BOTH);
    	System.out.println(url);
//        Person person = new Person("Larry");
        assertEquals("https://bittrex.com/api/v1.1/public/getorderbook?market=BTC-SC&type=both", url);
    }

}

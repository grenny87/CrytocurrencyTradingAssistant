package org.detectpumpingcoin.request;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.detectpumpingcoin.exception.BittrexRequestException;

public class AbstractRequestClient {
	
	final static Logger logger = Logger.getAnonymousLogger();
	
	private HttpClient httpClient = HttpClientBuilder.create().build();
	
	protected String callApi(String api) {
		HttpGet httpGetRequest = new HttpGet(api);
		String jsonString;
		try {
			HttpResponse httpResponse = httpClient.execute(httpGetRequest);
			System.out.println("----------------------------------------");
			System.out.println(httpResponse.getStatusLine());
			System.out.println("----------------------------------------");

			HttpEntity entity = httpResponse.getEntity();
			jsonString = this.getJsonStringFromReponse(entity);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cannot call bittrex api " + api  , e);
			throw new BittrexRequestException("Cannot call bittrex api", e);
		} 
		return jsonString;
	}
	
	private String getJsonStringFromReponse(HttpEntity entity) throws UnsupportedOperationException, IOException {
		StringBuilder builder = new StringBuilder();

		byte[] buffer = new byte[1024];
		if (entity != null) {
			InputStream inputStream = entity.getContent();
			try {
				int bytesRead = 0;
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				while ((bytesRead = bis.read(buffer)) != -1) {
					String chunk = new String(buffer, 0, bytesRead);
					builder.append(chunk);
				}
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Cannot read request response " + entity.toString()  , e);
			} finally {
				try {
					inputStream.close();
				} catch (Exception e) {
					logger.log(Level.SEVERE, "Cannot close request " + entity.toString()  , e);
				}
			}
		}
		return builder.toString();
	}
}

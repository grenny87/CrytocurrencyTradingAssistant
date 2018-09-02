package org.detectpumpingcoin.exception;

public class BittrexRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public BittrexRequestException() {
        super();
    }
    public BittrexRequestException(String s) {
        super(s);
    }
    public BittrexRequestException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public BittrexRequestException(Throwable throwable) {
        super(throwable);
    }

}

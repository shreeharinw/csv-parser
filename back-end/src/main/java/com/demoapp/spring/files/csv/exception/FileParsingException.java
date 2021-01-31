package com.demoapp.spring.files.csv.exception;

public class FileParsingException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public FileParsingException(String message) {
        super(message);
    }

    public FileParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}

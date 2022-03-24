package com.capgemini.pokecity.exception;

public class URLException extends Exception{
    private static final String DEFAULT_MESSAGE = "URL Não encontrada";

    private String message;

    public URLException(){
        super(DEFAULT_MESSAGE);
        this.message = DEFAULT_MESSAGE;
    }

    public URLException(String message){
        super(message);
        this.message = message;
    }
}

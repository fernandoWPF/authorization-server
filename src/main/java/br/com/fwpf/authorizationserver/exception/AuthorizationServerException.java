package br.com.fwpf.authorizationserver.exception;

public class AuthorizationServerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AuthorizationServerException(String message) {
        super(message);
    }

}

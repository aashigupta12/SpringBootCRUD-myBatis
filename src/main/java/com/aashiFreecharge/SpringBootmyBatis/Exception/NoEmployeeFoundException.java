package com.aashiFreecharge.SpringBootmyBatis.Exception;

public class NoEmployeeFoundException extends RuntimeException{
    public NoEmployeeFoundException(String resource) {
        super(resource);
    }
}

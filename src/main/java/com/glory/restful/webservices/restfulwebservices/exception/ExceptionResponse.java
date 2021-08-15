package com.glory.restful.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private final LocalDateTime dateTime;
    private final String message;
    private final String details;

    public ExceptionResponse(LocalDateTime dateTime, String message, String details) {
        this.dateTime = dateTime;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}

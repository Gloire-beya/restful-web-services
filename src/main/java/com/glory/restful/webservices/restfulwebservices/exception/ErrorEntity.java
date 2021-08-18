package com.glory.restful.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorEntity {
    private final LocalDateTime dateTime;
    private final String message;
    private final String url;

    public ErrorEntity(LocalDateTime dateTime, String message, String url) {
        this.dateTime = dateTime;
        this.message = message;
        this.url = url;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }
}

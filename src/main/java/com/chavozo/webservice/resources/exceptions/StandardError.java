package com.chavozo.webservice.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
    private Integer status;
    private String message;
    private Long timeStamp;

    public StandardError(Integer status, String message, Long timeStamp) {
        super();
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}

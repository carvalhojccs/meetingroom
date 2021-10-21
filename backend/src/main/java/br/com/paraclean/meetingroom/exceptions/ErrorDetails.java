package br.com.paraclean.meetingroom.exceptions;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class ErrorDetails {
    private Instant timestamp;
    private String msg;
    private String details;

    public ErrorDetails(){

    }

    public ErrorDetails(Instant timestamp, String msg, String details) {
        this.timestamp = timestamp;
        this.msg = msg;
        this.details = details;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public String getDetails() {
        return details;
    }
}

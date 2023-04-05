package com.ekang.todorestapi.exception;

import org.springframework.util.Assert;

public class TodoResponseStatusException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int status;
    private String reason;

    public TodoResponseStatusException(int status) {
        super();
        Assert.notNull(status, "TodoHttpResponse is required");
        this.status = status;
    }

    public TodoResponseStatusException(int status, String reason) {
        super(reason);
        Assert.notNull(status, "TodoHttpResponse is required");
        this.status = status;
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }
}

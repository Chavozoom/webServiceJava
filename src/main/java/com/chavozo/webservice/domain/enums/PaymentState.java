package com.chavozo.webservice.domain.enums;

public enum PaymentState {

    PENDENT(1, "pendent"),
    COMPLETED(2, "completed"),
    CANCELLED(3, "cancelled");

    private int code;
    private String description;

    private PaymentState(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentState toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (PaymentState x : PaymentState.values()) {
            if (code.equals(x.code)) {
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid id: " + code);
    }
}

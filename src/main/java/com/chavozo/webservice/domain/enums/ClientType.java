package com.chavozo.webservice.domain.enums;

public enum ClientType {

    INDIVIDUAL(1, "individual"),
    LEGALENTITY(2, "legal entity");

    private int code;
    private String description;

    private ClientType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ClientType toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (ClientType x : ClientType.values()) {
            if (code.equals(x.code)) {
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid id: " + code);
    }
}

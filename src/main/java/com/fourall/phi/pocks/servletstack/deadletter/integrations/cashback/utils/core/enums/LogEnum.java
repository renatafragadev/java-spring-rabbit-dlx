package com.fourall.phi.pocks.servletstack.deadletter.integrations.cashback.utils.core.enums;

public enum LogEnum {

    MSG_ERROR_CONTENT_TYPE("Error in message validation: invalid content_type"),
    MSG_ERROR_MESSAGE_ID("Error in message validation: message_id is required"),
    MSG_ERROR_TIMESTAMP("Error in message validation: timestamp is required"),
    MSG_ERROR_BODY("Error in message validation: The message could not be deserialized");
    private final String value;

    LogEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

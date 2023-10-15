package com.surajmaity1.txtmsg.twilio;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;


public class TxtMsgRequest {

    @NotBlank
    private final String phoneNumber;     // receiver phone number
    @NotBlank
    private final String message;

    public TxtMsgRequest(@JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "TxtMsgRequest{" +
                "toPhoneNumber='" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

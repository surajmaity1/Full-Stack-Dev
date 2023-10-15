package com.surajmaity1.txtmsg.twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioTxtMsgSender implements TxtMsgSender{

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioTxtMsgSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioTxtMsgSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendTxtMsg(TxtMsgRequest txtMsgRequest) {

        if (phoneNumberValidator(txtMsgRequest.getPhoneNumber())) {
            PhoneNumber toPhoneNumber = new PhoneNumber(txtMsgRequest.getPhoneNumber());
            PhoneNumber fromPhoneNumber = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = txtMsgRequest.getMessage();

            MessageCreator messageCreator = Message.creator(toPhoneNumber, fromPhoneNumber, message);
            messageCreator.create();

            LOGGER.info("Text Message Send {}", txtMsgRequest);

        }
        else {
            throw new IllegalArgumentException(
                    "Invalid Phone Number : " + txtMsgRequest.getPhoneNumber()
            );
        }


    }

    private boolean phoneNumberValidator(String ph) {
        // Build phoneNumberValidator
        return true;
    }
}

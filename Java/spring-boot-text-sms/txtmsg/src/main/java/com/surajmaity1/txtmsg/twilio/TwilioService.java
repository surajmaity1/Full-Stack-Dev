package com.surajmaity1.txtmsg.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {
    private final TxtMsgSender txtMsgSender;

    @Autowired
    public TwilioService(@Qualifier("twilio") TwilioTxtMsgSender twilioTxtMsgSender) {
        this.txtMsgSender = twilioTxtMsgSender;
    }

    public void sendTextMsg(TxtMsgRequest txtMsgRequest) {
        txtMsgSender.sendTxtMsg(txtMsgRequest);
    }

}

package cz.rohlik.smsprojekt.json_sms;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DefaultSms extends Sms {

    private final String AUTH_NAME = "Rohlik";
    private final String AUTH_PASSWORD = "ad9df5b1c34cf9d7aa56ef7e36a6cd32";

    public Sms createSms(String recipient, String partsText){
        Auth auth = new Auth();
        auth.setName(AUTH_NAME);
        auth.setPassword(AUTH_PASSWORD);

        Message msg = createMsg(recipient, partsText);
        List<Message> messages = new ArrayList<>();
        messages.add(msg);

        Sms sms = new Sms(auth, messages);

        return sms;
    }

    public Message createMsg(String recipient, String partsText){
        Parts part = new Parts();
        part.setOrder(0);
        part.setText(partsText);
        part.setUdh(null);
        List<Parts> parts = new ArrayList<>();
        parts.add(part);

        Message message = new Message();
        message.setMethod("sms");
        message.setMsgType("text");
        message.setTextSender("RohlikCZ");
        message.setUniq(UUID.randomUUID().toString());
        message.setSender("999000000001");
        message.setRecipient(recipient);
        message.setDlr(1);
        message.setValidity(60);
        message.setPriority(12);
        message.setOpmid("1");
        message.setKw("ROHLIK");
        message.setText("Rohlik.cz");
        message.setUrl(null);
        message.setParts(parts);

        return message;
    }

}

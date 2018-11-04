package cz.rohlik.smsprojekt.rabbit_sms;

import lombok.Data;

@Data
public class RabbitSms {
    public String number;
    public String message;
    public Integer orderId;
    public Integer priority;
    public String identifier;
    public String sendAt;
}

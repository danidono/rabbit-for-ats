package cz.rohlik.smsprojekt.controllers;

import cz.rohlik.smsprojekt.rabbit_sms.RabbitSms;
import cz.rohlik.smsprojekt.services.SendingServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class SendController {

    private final SendingServices sendingServices;

    @Autowired
    public SendController(SendingServices sendingServices){
        this.sendingServices = sendingServices;
    }

    @RabbitListener(queues = "sms.test")
    public void sendSms(final RabbitSms sms){
        log.info("RABBIT SMS Controller: " + sms.toString());
        try {
            sendingServices.sendSms(sms);
        }
        catch(InterruptedException e){
        }
    }
}

package cz.rohlik.smsprojekt.services;

import cz.rohlik.smsprojekt.json_sms.DefaultSms;
import cz.rohlik.smsprojekt.json_sms.Sms;
import cz.rohlik.smsprojekt.rabbit_sms.RabbitSms;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
public class SendingServices {

    @Autowired
    private RestTemplate restTemplate;
    private DefaultSms atsSms;

    public void sendSms(final RabbitSms rabbitSms) throws InterruptedException{
        log.info("Message received from RabbitMQ queue: " + rabbitSms.toString());
        final String url = "http://smsport3.atspraha.cz";
        /*
         createSms from rabbit to ats(uniq = rabbitSms orderId, recipient = rabbitSms number, text = rabbitSms message)
          */
        Sms sms = atsSms.createSms(rabbitSms.getNumber(), rabbitSms.getMessage());
//        List<Sms> result = restTemplate.postForObject(url, sms, List.class);
//        log.info("ATS Response: " + result.toString());
        Thread.sleep(1000);
    }


}

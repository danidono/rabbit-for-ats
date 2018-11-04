package cz.rohlik.smsprojekt;

import cz.rohlik.fr.template.RohlikRestTemplate;
import cz.rohlik.smsprojekt.services.SendingServices;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
@EnableRabbit
public class SmsprojektApplication implements RabbitListenerConfigurer{

    @Bean
    public RestTemplate restTemplate(){
        return new RohlikRestTemplate();
    }

    @Bean
    public SendingServices sendingServices(){
        return new SendingServices();
    }

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }

    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(consumerJackson2MessageConverter());
        return factory;
    }

    @Override
    public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }

    public static void main(String[] args) {
        SpringApplication.run(SmsprojektApplication.class, args);
    }
}
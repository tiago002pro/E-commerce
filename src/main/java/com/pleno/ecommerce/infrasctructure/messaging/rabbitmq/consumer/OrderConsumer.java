package com.pleno.ecommerce.infrasctructure.messaging.rabbitmq.consumer;

import com.pleno.ecommerce.infrasctructure.messaging.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receive(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}
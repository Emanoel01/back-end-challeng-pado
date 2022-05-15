package com.challenge.infra.queue.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RabbitConfiguration {

    private String queueName;
    private String exchangeName;
    private String routeKey;

    public RabbitConfiguration(String queueName, String exchangeName, String routeKey) {
        this.queueName = queueName;
        this.exchangeName = exchangeName;
        this.routeKey = routeKey;
    }

    DirectExchange exchange(){return new DirectExchange(this.exchangeName);}

    Queue queue(){return QueueBuilder.durable(this.queueName).build();}

    Binding binding(){return BindingBuilder.bind(queue()).to(exchange()).with(this.routeKey); }

}

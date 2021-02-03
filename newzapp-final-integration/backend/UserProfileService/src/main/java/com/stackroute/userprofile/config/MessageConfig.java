package com.stackroute.userprofile.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    @Bean
    public Queue newUserQueue() {
        return new Queue("newuser_queue");
    }

    @Bean
    public TopicExchange newUserExchange() {
        return new TopicExchange("newuser_exchange");
    }

    @Bean
    public Binding binding(Queue newUserQueue, TopicExchange newUserExchange) {
        return BindingBuilder.bind(newUserQueue).to(newUserExchange).with("newuser_routekey");
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}

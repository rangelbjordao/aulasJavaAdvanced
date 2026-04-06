package fiap.com.br.votinggateway.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public final static String QUEUE_NAME = "voting.queue";
    public final static String EXCHANGE_NAME = "voting.exchange";
    public final static String ROUTING_KEY = "voting.routingKey";

    @Bean
    Queue queue(){
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(ROUTING_KEY);
    }
}

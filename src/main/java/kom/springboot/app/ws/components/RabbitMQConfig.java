package kom.springboot.app.ws.components;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class RabbitMQConfig {

    @Value("${rabbitMQ.direct.exchange}") 
    private String exchangeName;
    
    @Value("${rabbitMQ.direct.exchange.route.key}") 
    private String exchangeRouteKey;
  
    @Value("${rabbitMQ.name:Default welcome.rabbitMQ.queue}") 
    private String queueName;

    @Bean
    public Queue configureQueue() {
    	
    	Queue q= new Queue(queueName, true);   	
    	log.info("configureQueue() <{}>", q.getName());   	
    	return q;
    }
    
    @Bean 
    public DirectExchange configureExchange()
    {
    		
    	log.info("configureExchange() <{}>",exchangeName);
    	return ExchangeBuilder.directExchange(exchangeName)
                .durable(true)
                .build();
    }

    @Bean
    public Binding configureBinding(Queue queue, DirectExchange exchange)
    {
    	log.info("configureBinding() <{}>", exchangeRouteKey);
    	
        return BindingBuilder.bind(queue)
            .to(exchange)
            .with(exchangeRouteKey);
    }
}

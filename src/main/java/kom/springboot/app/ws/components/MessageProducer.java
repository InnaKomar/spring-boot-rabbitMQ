package kom.springboot.app.ws.components;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    
    @Value("${rabbitMQ.direct.exchange.route.key}") 
    private String exchangeRouteKey;
  
    @Value("${rabbitMQ.direct.exchange}") 
    private String exchangeName;
    
    public void sendMessage(String message)
    {
    	log.info("sendMessage() Exchange name: <{}> Echnage Route Key: <{}>", exchangeName, exchangeRouteKey);
        rabbitTemplate.convertAndSend(
            exchangeName, exchangeRouteKey, message);
    }
}

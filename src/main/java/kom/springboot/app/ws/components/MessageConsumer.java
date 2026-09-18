package kom.springboot.app.ws.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageConsumer 
{
	@RabbitListener(queues = "${rabbitMQ.name}")
    public void receivedMessage(String message)
    {
        log.info("Received message <{}> ", message);
    }
}

package kom.springboot.app.ws.components;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageProducer messageProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
    	log.info("sendMessage() <{}>", message);
        messageProducer.sendMessage(message);
        return message;
    }
}

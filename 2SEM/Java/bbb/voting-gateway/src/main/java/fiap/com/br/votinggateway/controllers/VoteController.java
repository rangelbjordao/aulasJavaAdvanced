package fiap.com.br.votinggateway.controllers;

import fiap.com.br.votinggateway.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final RabbitTemplate rabbitTemplate;

    public VoteController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public record VoteRequest(String participantId){}

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void registryVote(@RequestBody VoteRequest request){
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_NAME,
                RabbitConfig.ROUTING_KEY,
                request.participantId()
        );
    }

}

package fiap.com.br.ticketservice;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.service.invoker.HttpServiceArgumentResolver;

@Slf4j
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final RestTemplate restTemplate;
    public record PaymentResponse(String status){}

    public TicketService(TicketRepository ticketRepository, RestTemplate restTemplate) {
        this.ticketRepository = ticketRepository;
        this.restTemplate = restTemplate;
    }

    @Transactional
    public void purchase(Long ticketId){
        Ticket ticket = ticketRepository.findByIdForUpdate(ticketId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found")
        );

        // verificar se tem disponivel
        if(ticket.getAvailable() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No ticket available");
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}

        var response = restTemplate.postForObject("http://PAYMENT-SERVICE/payments", null, PaymentResponse.class);

        if(response != null){
            log.info("Payment response: {}", response.status());
        }

        //realizar a venda (decremento)
        ticket.setAvailable(ticket.getAvailable() - 1);

        //salvar
        //ticketRepository.save(ticket);

    }

}

package fiap.com.br.ticketservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final TicketRepository ticketRepository;
    public record PurchaseResponse(String status){}

    public TicketController(TicketService ticketService, TicketRepository ticketRepository) {
        this.ticketService = ticketService;
        this.ticketRepository = ticketRepository;
    }

    @PostMapping("/purchase/{ticketId}")
    public ResponseEntity<PurchaseResponse> purchase(@PathVariable Long ticketId){
        try{
            ticketService.purchase(ticketId);
        }catch (ResponseStatusException e) {
            return ResponseEntity.badRequest().body(new PurchaseResponse("Failed: " + e.getReason()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body( new PurchaseResponse("Success") );
    }

    @GetMapping
    public List<Ticket> getTickets(){
        return ticketRepository.findAll();
    }

}

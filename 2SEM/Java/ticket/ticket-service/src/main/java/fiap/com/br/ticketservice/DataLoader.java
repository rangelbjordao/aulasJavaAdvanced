package fiap.com.br.ticketservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final TicketRepository ticketRepository;

    public DataLoader(TicketRepository ticketRepository) {
        super();
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ticketRepository.save(new Ticket(null, "Show de Rock", 10));
    }
}

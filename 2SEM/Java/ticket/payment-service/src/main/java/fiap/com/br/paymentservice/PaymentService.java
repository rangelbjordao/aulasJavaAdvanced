package fiap.com.br.paymentservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

@Slf4j
@Service
public class PaymentService {

    private Random random = new Random();

    @Retryable(
            includes = ResponseStatusException.class,
            maxRetries = 5,
            // exponential backoff
            delay = 500,
            multiplier = 2,
            maxDelay = 10_000,
            jitter = 100
    )
    public String processPayment(){
        log.info("Processing payment...");
        if (random.nextInt() < 70){
            log.info("❌ Payment failed");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Fail to process payment");
        }

        log.info("✅ Payment processed successfully");
        return "Success";
    }

}

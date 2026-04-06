package fiap.com.br.paymentservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public record PaymentResponse(String status){}

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(){

        var response = new PaymentResponse( paymentService.processPayment() );

        return ResponseEntity.ok(response);
    }
}

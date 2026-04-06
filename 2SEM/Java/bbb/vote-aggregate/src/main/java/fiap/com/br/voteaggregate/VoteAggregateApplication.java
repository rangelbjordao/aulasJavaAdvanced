package fiap.com.br.voteaggregate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VoteAggregateApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoteAggregateApplication.class, args);
    }

}

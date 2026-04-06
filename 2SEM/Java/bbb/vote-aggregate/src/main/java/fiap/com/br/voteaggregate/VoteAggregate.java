package fiap.com.br.voteaggregate;

import fiap.com.br.voteaggregate.config.RabbitConfig;
import fiap.com.br.voteaggregate.config.VoteCountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
@Component
public class VoteAggregate {

    private final VoteCountRepository voteCountRepository;
    private ConcurrentMap<String, Integer> voteCounts = new ConcurrentHashMap<>();

    public VoteAggregate(VoteCountRepository voteCountRepository) {
        this.voteCountRepository = voteCountRepository;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void aggregate(String participantId){
        voteCounts.merge(participantId, 1, Integer::sum);
        log.info("Voto received for participant {}", participantId);
    }

    @Scheduled(fixedDelay = 5_000) // a cada 5 segundos
    public void flush(){
        if(voteCounts.isEmpty()) return;
        log.info("Flushing counts to database...");

        voteCounts.forEach(this::persistCount);
        voteCounts.clear();
    }

    private void persistCount(String participantId, Integer total) {
        VoteCount voteCount = voteCountRepository.findById(participantId)
                .orElseGet(() -> new VoteCount(participantId, 0));
        voteCount.setTotal(voteCount.getTotal() + total);
        voteCountRepository.save(voteCount);
    }


    public Map<String, Integer> getVoteCounts() {
        return voteCounts;
    }
}

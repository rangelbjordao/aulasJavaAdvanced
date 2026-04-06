package fiap.com.br.voteaggregate.config;

import fiap.com.br.voteaggregate.VoteCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteCountRepository extends JpaRepository<VoteCount, String> {
}

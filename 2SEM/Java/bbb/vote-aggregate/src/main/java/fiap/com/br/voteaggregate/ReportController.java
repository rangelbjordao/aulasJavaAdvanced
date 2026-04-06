package fiap.com.br.voteaggregate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final VoteAggregate voteAggregate;

    public ReportController(VoteAggregate voteAggregate) {
        this.voteAggregate = voteAggregate;
    }

    @GetMapping
    public Map<String, Integer> getVoteCounts() {
        return voteAggregate.getVoteCounts();
    }

}

package org.example.plannerapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/palnner")
public class PlannerController {
    @GetMapping
    public  String getPlanner(@RequestParam String activity){
        return "Voce nao deve %s hoje, o clima nao esta bom".formatted(activity);
    }
}

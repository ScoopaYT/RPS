package com.example.teachMyself;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RPSController {
    private final RPSService rpsService;

    @Autowired
    public RPSController(RPSService rpsService){
        this.rpsService = rpsService;
    }

    @GetMapping("/playRPS")
    public RPSResult getRandomChoiceRPS(@RequestParam(value = "choice", defaultValue = "NotPicked") String choice){
        return rpsService.getResult(choice, false);
    }

    @GetMapping("/playRPSP")
    public RPSResult getRandomChoiceRPSP(@RequestParam(value = "choice", defaultValue = "NotPicked") String choice){
        return rpsService.getResult(choice, true);
    }
}

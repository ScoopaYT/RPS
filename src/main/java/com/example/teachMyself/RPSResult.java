package com.example.teachMyself;

import java.util.Random;

public class RPSResult {

    private String aiChoice;

    private String playerChoice;

    private String outcome;

    public RPSResult(String aiChoice, String playerChoice, String outcome){
        this.aiChoice = aiChoice;
        this.playerChoice = playerChoice;
        this.outcome = outcome;
    }

    public String getAiChoice() {
        return aiChoice;
    }

    public String getPlayerChoice() {
        return playerChoice;
    }

    public String getOutcome() {
        return outcome;
    }
}

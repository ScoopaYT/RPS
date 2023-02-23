package com.example.teachMyself;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RPSService {

    public String getAiChoice(Boolean rpsp){
        Random randomize = new Random();
        String[] choices = new String[]{"Rock", "Paper", "Scissors", "Pond"};
        if(rpsp){
            return choices[randomize.nextInt(4)];
        } else {
            return choices[randomize.nextInt(3)];
        }

    }
    public RPSResult getResult(String playerChoice, Boolean rpsp) {
        String aiChoice = getAiChoice(rpsp);
        return new RPSResult(aiChoice, playerChoice, calculateOutcome(aiChoice, playerChoice));
    }

    public String calculateOutcome(String aiChoice, String playerChoice){
        String outcome = new String();
        System.out.println(aiChoice + playerChoice);
        if(aiChoice.equalsIgnoreCase(playerChoice)){
            outcome = "Tie";
        } else if(aiChoice.equals("Rock") && playerChoice.equalsIgnoreCase("Scissors")){
            outcome = "Player lost";
        } else if(aiChoice.equals("Scissors") && playerChoice.equalsIgnoreCase("Paper")){
            outcome = "Player lost";
        } else if(aiChoice.equals("Paper") && (playerChoice.equalsIgnoreCase("Rock") || playerChoice.equalsIgnoreCase("Pond"))){
            outcome = "Player lost";
        } else if(aiChoice.equals("Pond") && (playerChoice.equalsIgnoreCase("Rock") || playerChoice.equalsIgnoreCase("Scissors"))){
            outcome = "Player lost";
        }else if(playerChoice.equals("NotPicked")){
            outcome = "Please enter /getResult?choice=X , with X being replaced by your choice";
        } else {
            outcome = "Player won";
        }
        System.out.println(outcome);
        return outcome;
    }


}

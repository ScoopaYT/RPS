package com.example.teachMyself;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RPSServiceTest {

    @Autowired
    private RPSController controller;

    @Test
    void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
    }

    @Test
    void getResultTest(){
        RPSResult testRpsResult = new RPSResult("Rock", "Paper", "Player won");
        assertEquals("Rock", testRpsResult.getAiChoice());
        assertEquals("Paper", testRpsResult.getPlayerChoice());
        assertEquals("Player won", testRpsResult.getOutcome());
    }

    @Test
    void calculateOutcomeTest(){
        RPSService rpsService = new RPSService();
        assertEquals("Player won", rpsService.calculateOutcome("Rock", "Paper"));
        assertEquals("Player lost", rpsService.calculateOutcome("Scissors", "Paper"));
        assertEquals("Tie", rpsService.calculateOutcome("Paper", "Paper"));
        assertEquals("Please enter /getResult?choice=X , with X being replaced by your choice", rpsService.calculateOutcome("Scissors", "NotPicked"));
    }

    //@Test
    //void rpsResultTest() throws Exception {
    //    mvc.perform(get("/playRPS?choice=Rock")).andExpect(jsonPath("$errors", hasSize(3)));
    //}
}

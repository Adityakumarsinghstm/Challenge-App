package com.embarkx.ChanllengeApp.controller;

import com.embarkx.ChanllengeApp.Entities.Challenge;
import com.embarkx.ChanllengeApp.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges()
    {
        return challengeService.getAllChallenges();
    }
    @PostMapping("/challenges")
    public String addChallenges(@RequestBody Challenge challenge)
    {
       boolean isAdded = challengeService.addChallenges(challenge);
        if(isAdded == true)
        {
            return "Challenge Added Successfully";
        }
        else
        {
            return "Challenge not Added";
        }
    }

}

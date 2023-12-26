package com.embarkx.ChanllengeApp.service;

import com.embarkx.ChanllengeApp.Entities.Challenge;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChallengeService {

    private List<Challenge> challenges = new ArrayList<>();
    ChallengeService()
    {
        Challenge challenge1 = new Challenge(1,"january","Learning a new Programming language");
        challenges.add(challenge1);
    }

    public List<Challenge> getAllChallenges()
    {
        return challenges;
    }

    public boolean addChallenges(@RequestBody Challenge challenge)
    {
        if(challenge!=null)
        {
            challenges.add(challenge);
            return true;
        }
        else {
            return false;
        }

    }
}

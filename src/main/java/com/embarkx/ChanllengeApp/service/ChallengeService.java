package com.embarkx.ChanllengeApp.service;

import com.embarkx.ChanllengeApp.Entities.Challenge;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChallengeService {

    private List<Challenge> challenges = new ArrayList<>();
    private long nextId = 1L;
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
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }
        else {
            return false;
        }

    }
    public Challenge getChallengeByMonth( String month)
    {
        for (Challenge challenge:challenges) {
            if(challenge.getMonth().equalsIgnoreCase(month))
            {
                return challenge;
            }
        }
        return null;
    }
}

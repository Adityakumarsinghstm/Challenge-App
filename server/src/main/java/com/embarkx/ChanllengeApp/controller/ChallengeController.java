package com.embarkx.ChanllengeApp.controller;

import com.embarkx.ChanllengeApp.Entities.Challenge;
import com.embarkx.ChanllengeApp.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges()
    {
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge)
    {
       boolean isAdded = challengeService.addChallenges(challenge);
        if(isAdded == true)
        {
            return new ResponseEntity<>("Challenge Added Successfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Challenge not Added",HttpStatus.NOT_FOUND) ;
        }
    }
    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallengeByMonth(@PathVariable String  month)
    {
        Challenge challenge = challengeService.getChallengeByMonth(month);
        if(challenge!=null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge)
    {
        boolean isUpdated = challengeService.updateChallenge(id,updatedChallenge);
        if(isUpdated == true)
        {
            return new ResponseEntity<>("Challenge updated Successfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Challenge not updated",HttpStatus.NOT_FOUND) ;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id)
    {
        boolean isDeleted = challengeService.deleteChallenge(id);
        if(isDeleted == true)
        {
            return new ResponseEntity<>("Challenge Deleted Successfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Challenge not Deleted",HttpStatus.NOT_FOUND) ;
        }
    }

}

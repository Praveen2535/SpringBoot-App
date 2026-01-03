package com.example.Datajpa.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class challengeController {
    private challengeService challengeService;

    public challengeController(challengeService challengeService){
        this.challengeService = challengeService;
    }

    private List<challenge> challenges = new ArrayList<>();





    @GetMapping("/challenges")
    public List<challenge> getAllchallenges(){
        return challengeService.getAllchallenges();
    }

    @PostMapping("/challenge")
    public String addChallenge(@RequestBody  challenge challenge) {
        boolean isChallengeAdded =
            challengeService.addChallenge(challenge);
       if(isChallengeAdded)
           return "Successfully Added";
       else
           return "Failed to Add";
    }

    @GetMapping("/challenge/{month}")
    public ResponseEntity<challenge> getChallenge(@PathVariable  String month) {
        challenge challenge = challengeService.getChallenge(month);
        if(challenge != null) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/challenge{id}")
    public  ResponseEntity<String> updeteChallenge(@PathVariable Long id,@RequestBody challenge updateChallenge) {
        boolean isChallengeUpdated = challengeService.updateChallenge(id,updateChallenge);
        if(isChallengeUpdated) {
            return new ResponseEntity<>("challenge updated",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("challenge not updated",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/challenge/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted) {
            return new ResponseEntity<>("challenge deleted successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity("challenge not deleted",HttpStatus.NOT_FOUND);
        }

    }
}

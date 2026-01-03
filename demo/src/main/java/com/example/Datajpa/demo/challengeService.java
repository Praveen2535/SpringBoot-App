package com.example.Datajpa.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class challengeService {

    private List<challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;


    public challengeService() {


    }

    public List<challenge> getAllchallenges() {
        return challenges;
    }

    public boolean addChallenge(challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        } else {
            return false;
        }


    }

    public challenge getChallenge(String month) {
        for(challenge challenge : challenges) {
            if(challenge.getMonth().equalsIgnoreCase(month)){
                return challenge;

            }

        }
        return null;
    }

    public boolean updateChallenge(Long id,challenge updateChallenge) {
        for(challenge challenge : challenges) {
            if (challenge.getId().equals(id)) {
                challenge.setMonth(updateChallenge.getMonth());
                challenge.setDescription(updateChallenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
       return challenges.removeIf(challenge -> challenge.getId().equals(id));

    }
}
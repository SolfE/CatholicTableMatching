package com.csec.CatholicTableMatching.service;

import com.csec.CatholicTableMatching.domain.*;
import com.csec.CatholicTableMatching.repository.MatchRepository;
import com.csec.CatholicTableMatching.repository.PreferenceRepository;
import com.csec.CatholicTableMatching.repository.UserRepository;
import com.csec.CatholicTableMatching.repository.WaitingAnotherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

@Service
@RequiredArgsConstructor
public class MatchingService {
    private Queue<Customer> waitingQueue = new LinkedList<>();
    private UserRepository userRepository;
    private PreferenceRepository preferenceRepository;
    private MatchRepository matchRepository;


    public boolean isWaitingQueueEmpty() {
        return waitingQueue.isEmpty();
    }

    public void addUserToQueue(Customer user) {
        waitingQueue.offer(user);
    }

    private WaitingAnotherRepository waitingAnotherRepository;

    public void processMatchWithUserInQueue(MatchForm matchForm) {

            // Create and save a new match entity
            WaitingAnother newWaiting = new WaitingAnother();
            newWaiting.setUser(matchForm.getUser());
            newWaiting.setFoodType(matchForm.getFoodtype());
            newWaiting.setMatchDate(new Date());
            newWaiting.setTimeSlot(matchForm.getTimeSlot());
            waitingAnotherRepository.save(newWaiting); // Save the match to the database using MatchRepository

            // Additional logic as needed
    }

}


package com.embarkx.ChanllengeApp.Repository;

import com.embarkx.ChanllengeApp.Entities.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challenge,Long> {

    Optional<Challenge> findByMonthIgnoreCase(String month);
}

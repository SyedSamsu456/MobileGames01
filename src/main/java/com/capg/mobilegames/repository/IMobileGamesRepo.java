package com.capg.mobilegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mobilegames.beans.MobileGames;

@Repository
public interface IMobileGamesRepo extends JpaRepository<MobileGames, Long> {

}

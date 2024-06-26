package com.fantasy.stats.springfantasystats.services.LeagueService;

import com.fantasy.stats.springfantasystats.exceptions.LeagueNotFoundException;
import com.fantasy.stats.springfantasystats.models.LeaguesYahoo;
import com.fantasy.stats.springfantasystats.repositories.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;

    @Autowired
    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public LeaguesYahoo getLeagueBasicInfoById(Integer leagueId) {
        return leagueRepository.findById(leagueId)
                .orElseThrow(
                        () -> new LeagueNotFoundException("League with id " + leagueId + " not found."));
    }

    @Override
    public LeaguesYahoo addLeague(LeaguesYahoo league) {
        return leagueRepository.save(league);
    }
}
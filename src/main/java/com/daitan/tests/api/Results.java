package com.daitan.tests.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {
  private Team team1;
  private Team team2;

  public Results(String t1, String t2) {
    this.team1 = new Team(t1);
    this.team2 = new Team(t2);
  }

  @JsonProperty("Time1")
  public Team getTeam1() {
    return team1;
  }

  @JsonProperty("Time2")
  public Team getTeam2() {
    return team2;
  }
}

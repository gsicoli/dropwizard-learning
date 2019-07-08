package com.daitan.tests.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Random;

public class Team {
  private String name;
  private int score;

  public Team(String name) {
    Random r = new Random();
    this.name = name;
    this.score = r.nextInt(4);
  }

  @JsonProperty("Nome")
  public String getName() {
    return name;
  }

  @JsonProperty("Placar")
  public int getScore() {
    return score;
  }
}

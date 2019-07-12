package com.daitan.tests.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamScore {
  @JsonProperty
  public String name;

  @JsonProperty
  public int score;
}

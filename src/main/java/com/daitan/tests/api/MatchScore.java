package com.daitan.tests.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchScore {
  @JsonProperty
  public TeamScore team1;
  @JsonProperty
  public TeamScore team2;
}
